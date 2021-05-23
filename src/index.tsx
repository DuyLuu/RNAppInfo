import { NativeModules } from 'react-native';

type AppInfoType = {
  multiply(a: number, b: number): Promise<number>;
};

const { AppInfo } = NativeModules;

export default AppInfo as AppInfoType;
