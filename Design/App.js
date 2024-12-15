import React from'react';
import { SafeAreaView } from 'react-native';
// import StackNavigation from './navigation/navigationStack';
import { NavigationContainer } from '@react-navigation/native';
import { StatusBar } from 'expo-status-bar';
import StackNavigator from './navigation/StackNavigator';
const App = () => {
  return (
    <SafeAreaView style={{ flex: 1 }}>
      <StatusBar barStyle="light-content" backgroundColor="#6a51ae" />
      <NavigationContainer>
        {isSignedIn ? <StackNavigator /> : <AuthStack />}
    </NavigationContainer>
    </SafeAreaView>
  );
}
export default App;