import React from 'react';
import { createNativeStackNavigator } from '@react-navigation/native-stack';
import { createBottomTabNavigator } from '@react-navigation/bottom-tabs';
import { createDrawerNavigator } from '@react-navigation/drawer';
import { Image, View, StyleSheet, Text } from 'react-native';

import SignupScreen from '../screens/auth/SignupScreen';
import LoginScreen from '../screens/auth/LoginScreen';
import ForgotPasswordScreen from '../screens/auth/ForgotPasswordScreen';
import ResetPasswordScreen from '../screens/auth/ResetPasswordScreen';

import HomeScreen from '../screens/tabs/HomeScreen';
import CalenderScreen from '../screens/tabs/CalenderScreen';
import ProfileScreen from '../screens/tabs/ProfileScreen';

import SCREENS from '../screens/index';
import Header from '../components/Header';
import { Calendar } from 'react-native-calendars';

const Stack = createNativeStackNavigator();
const Tab = createBottomTabNavigator();
const Drawer = createDrawerNavigator();

const ICONS = {
  HOME: require('../assets/images/home.png'),
  CALENDER: require('../assets/images/calendar.png'),
  PROFILE: require('../assets/images/user.png'),
  HAMBURGER: require('../assets/images/hamburger.png'),
  NOTIFICATION: require('../assets/images/notification.png'),
};



const TabNavigator = () => {
  return (
    <Tab.Navigator
      screenOptions={{ headerShown: false }}
    >
      <Tab.Screen
        name={SCREENS.HOME}
        component={HomeScreen}
        options={{
          title: 'Home',
          tabBarIcon: ({ focused }) => (
            <Image
              source={ICONS.HOME}
              style={{
                height: 30,
                width: 30,
                tintColor: focused ? '#007AFF' : '#000',
              }}
            />
          ),
        }}
      />
      <Tab.Screen
        name={SCREENS.CALENDER}
        component={CalenderScreen}
        options={{
          title: 'Calendar',
          tabBarIcon: ({ focused }) => (
            <Image
              source={ICONS.CALENDER}
              style={{
                height: 30,
                width: 30,
                tintColor: focused ? '#007AFF' : '#000',
              }}
            />
          ),
        }}
      />
      <Tab.Screen
        name={SCREENS.PROFILE}
        component={ProfileScreen}
        options={{
          title: 'Profile',
          tabBarIcon: ({ focused }) => (
            <Image
              source={ICONS.PROFILE}
              style={{
                height: 30,
                width: 30,
                tintColor: focused ? '#007AFF' : '#000',
              }}
            />
          ),
        }}
      />
    </Tab.Navigator>
  );
};

// SIDEBAR
const DrawerNavigator = ({ navigation }) => {
  return (
    <View style={styles.container}>
      {/* Add the Custom Header */}
      <Header
        title="SCHOOL IN"
        onMenuPress={() => navigation.toggleDrawer()}
        onNotificationPress={() => console.log('Notification Pressed')}
      />

      <Drawer.Navigator
        screenOptions={{
          headerShown: false, // Hide the default drawer header
          drawerStyle: {
            backgroundColor: '#f5f5f5',
            width: 250,
          },
          drawerActiveTintColor: '#007AFF',
          drawerInactiveTintColor: '#000',
          drawerLabelStyle: { fontSize: 16 },
        }}
      >
        <Drawer.Screen name="Home" component={TabNavigator} />
        <Drawer.Screen name="Profile" component={ProfileScreen} />
        <Drawer.Screen name="Calendar" component={Calendar} />
      </Drawer.Navigator>
      
    </View>
  );
};
const StackNavigation = () => {
  return (
    <Stack.Navigator initialRouteName={SCREENS.SIGNUP}>
      <Stack.Screen
        name={SCREENS.SIGNUP}
        component={SignupScreen}
        options={{ headerShown: false }}
      />
      <Stack.Screen
        name={SCREENS.LOGIN}
        component={LoginScreen}
        options={{ headerShown: false }}
      />
      <Stack.Screen
        name={SCREENS.FORGOTPASSWORD}
        component={ForgotPasswordScreen}
        options={{ headerShown: false }}
      />
      <Stack.Screen
        name={SCREENS.RESETPASSWORD}
        component={ResetPasswordScreen}
        options={{ headerShown: false }}
      />
      <Stack.Screen
        name={SCREENS.HOME}
        component={DrawerNavigator}
        options={{
          headerShown: false,
        }}
      />
    </Stack.Navigator>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
  },
});
export default StackNavigation;