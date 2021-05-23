#import "AppInfo.h"

@implementation AppInfo
- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE()

- (NSDictionary *)constantsToExport
{
    NSString *flavor;
#ifdef PRODUCTION
    flavor = @"Pro";
#elif BETA
    flavor = @"Demo";
#elif RELEASE
    flavor = @"Staging";
#elif DEBUG
    flavor = @"Dev";
#endif
    
    return @{@"appVersion"  : [[NSBundle mainBundle] objectForInfoDictionaryKey:@"CFBundleShortVersionString"],
             @"buildVersion": [[NSBundle mainBundle] objectForInfoDictionaryKey:(NSString *)kCFBundleVersionKey],
             @"bundleIdentifier"  : [[NSBundle mainBundle] bundleIdentifier],
             @"flavor": flavor,
             @"deviceModel": [[UIDevice currentDevice] model],
             };

}

+ (BOOL)requiresMainQueueSetup
{
    return YES;
}
@end
