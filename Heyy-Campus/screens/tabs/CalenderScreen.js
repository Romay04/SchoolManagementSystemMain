import { FlatList, StyleSheet, Text, View } from 'react-native';
import React, { useState } from 'react';
import { Calendar } from 'react-native-calendars';

const CalendarScreen = () => {
  // State to manage selected date and events
  const [selectedDate, setSelectedDate] = useState(null);
  const [events, setEvents] = useState({
    '2024-12-15': [{ title: 'Math Exam', time: '10:00 AM - 12:30 PM' }],
    '2024-12-20': [{ title: 'Carols Day', time: '1:00 PM - 4:00 PM' }],
  });

  // Function to handle date selection
  const handleDayPress = (day) => {
    setSelectedDate(day.dateString);
  };

  // Construct marked dates for the calendar
  const markedDates = {
    ...Object.fromEntries(
      Object.keys(events).map((date) => [date, { marked: true, dotColor: 'blue' }])
    ),
    ...(selectedDate && {
      [selectedDate]: { selected: true, selectedColor: 'blue' },
    }),
  };

  return (
    <View style={styles.container}>
      {/* Calendar Component */}
      <Calendar
        onDayPress={handleDayPress}
        markedDates={markedDates}
        theme={{
          todayTextColor: '#007BFF',
          arrowColor: '#007BFF',
          selectedDayBackgroundColor: '#007BFF',
          selectedDayTextColor: '#fff',
        }}
      />

      {/* Event List */}
      <View style={styles.eventList}>
        <Text style={styles.eventHeader}>
          Events on {selectedDate || 'No date selected'}
        </Text>
        {selectedDate && events[selectedDate] ? (
          <FlatList
            data={events[selectedDate]}
            keyExtractor={(item, index) => index.toString()}
            renderItem={({ item }) => (
              <View style={styles.eventItem}>
                <Text style={styles.eventTitle}>{item.title}</Text>
                <Text style={styles.eventTime}>{item.time}</Text>
              </View>
            )}
          />
        ) : (
          <Text style={styles.noEvents}>
            {selectedDate ? 'No events for this day.' : 'Please select a date to view events.'}
          </Text>
        )}
      </View>

      {/* Events Section */}
      <View style={styles.eventsSection}>
        <Text style={styles.sectionHeader}>Upcoming School Events</Text>
        <FlatList
          data={Object.entries(events).flatMap(([date, dayEvents]) =>
            dayEvents.map((event) => ({ date, ...event }))
          )}
          keyExtractor={(item, index) => index.toString()}
          renderItem={({ item }) => (
            <View style={styles.eventItem}>
              <Text style={styles.eventTitle}>{item.title}</Text>
              <Text style={styles.eventTime}>{item.time}</Text>
              <Text style={styles.eventDate}>Date: {item.date}</Text>
            </View>
          )}
        />
      </View>
    </View>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f9f9f9',
  },
  eventList: {
    flex: 1,
    marginTop: 10,
    paddingHorizontal: 16,
  },
  eventHeader: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  eventItem: {
    backgroundColor: '#fff',
    padding: 12,
    marginBottom: 8,
    borderRadius: 6,
    shadowColor: '#000',
    shadowOpacity: 0.1,
    shadowRadius: 5,
    elevation: 2,
  },
  eventTitle: {
    fontSize: 14,
    fontWeight: 'bold',
  },
  eventTime: {
    fontSize: 12,
    color: 'gray',
  },
  eventDate: {
    fontSize: 12,
    color: 'gray',
  },
  noEvents: {
    fontSize: 14,
    color: 'gray',
  },
  eventsSection: {
    padding: 16,
    backgroundColor: '#fff',
    borderTopWidth: 1,
    borderTopColor: '#ddd',
  },
  sectionHeader: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
  },
});

export default CalendarScreen;
