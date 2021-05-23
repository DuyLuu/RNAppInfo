import * as React from 'react';

import { StyleSheet, View, Text } from 'react-native';
import AppInfo from 'react-native-app-info';

export default function App() {
  const [result, setResult] = React.useState<number | undefined>();

  React.useEffect(() => {
    setResult(AppInfo);
  }, []);

  return (
    <View style={styles.container}>
      <Text>AppVersion: {result.appVersion}</Text>
      <Text>BuildVersion: {result.buildVersion}</Text>
      <Text>BundleIdentifier: {result.bundleIdentifier}</Text>
      <Text>Flavor: {result.flavor}</Text>
      <Text>DeviceModel: {result.deviceModel}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    alignItems: 'center',
    justifyContent: 'center',
  },
  box: {
    width: 60,
    height: 60,
    marginVertical: 20,
  },
});
