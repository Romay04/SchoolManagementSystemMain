import { View, Text } from 'react-native'
import React from 'react'
import { createDrawerNavigator } from '@react-navigation/drawer';
import TabNavigator from './TabNavigator';
import ProfileScreen from '../screens/tabs/ProfileScreen';
import Calendar from '../screens/tabs/CalenderScreen';
import { StyleSheet } from 'react-native';
import Header from '../components/Header';


const Drawer = createDrawerNavigator();
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
            headerShown: false,
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
const styles = StyleSheet.create({
container: {
    flex: 1,
},
});

export default DrawerNavigator