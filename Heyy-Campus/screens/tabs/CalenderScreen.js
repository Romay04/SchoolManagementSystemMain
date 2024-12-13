import { ScrollView, FlatList, StyleSheet, Text, View } from 'react-native';
import React, { useState } from 'react';
import { Calendar } from 'react-native-calendars';

const CalendarScreen = () => {
  // State to manage selected date, events, attendance, and timetable
  const [selectedDate, setSelectedDate] = useState(null);
  const [events, setEvents] = useState({
    '2024-12-15': [{ title: 'Math Exam', time: '10:00 AM - 12:30 PM' }],
    '2024-12-20': [{ title: 'Carols Day', time: '1:00 PM - 4:00 PM' }],
  });

  const [attendance, setAttendance] = useState({
    '2024-12-14': 'Present',
    '2024-12-15': 'Absent',
    '2024-12-16': 'Present',
  });

  const [timetable, setTimetable] = useState({
    Monday: [
      { subject: 'Math', time: '8:00 AM - 9:30 AM' },
      { subject: 'English', time: '10:00 AM - 11:30 AM' },
      { subject: 'Science', time: '12:00 PM - 1:30 PM' },
    ],
    Tuesday: [
      { subject: 'Science', time: '8:00 AM - 9:30 AM' },
      { subject: 'History', time: '10:00 AM - 11:30 AM' },
      { subject: 'Physical Education', time: '12:00 PM - 1:30 PM' },
    ],
    Wednesday: [
      { subject: 'Geography', time: '8:00 AM - 9:30 AM' },
      { subject: 'Art', time: '10:00 AM - 11:30 AM' },
      { subject: 'Computer Science', time: '12:00 PM - 1:30 PM' },
    ],
    Thursday: [
      { subject: 'Chemistry', time: '8:00 AM - 9:30 AM' },
      { subject: 'Physics', time: '10:00 AM - 11:30 AM' },
      { subject: 'Music', time: '12:00 PM - 1:30 PM' },
    ],
    Friday: [
      { subject: 'Biology', time: '8:00 AM - 9:30 AM' },
      { subject: 'Economics', time: '10:00 AM - 11:30 AM' },
      { subject: 'Drama', time: '12:00 PM - 1:30 PM' },
    ],
  });

  const handleDayPress = (day) => {
    setSelectedDate(day.dateString);
  };

  const markedDates = {
    ...Object.fromEntries(
      Object.keys(events).map((date) => [date, { marked: true, dotColor: 'blue' }])
    ),
    ...(selectedDate && {
      [selectedDate]: { selected: true, selectedColor: 'blue' },
    }),
  };

  return (
    <ScrollView style={styles.container}>
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

      {/* Events Section */}
      <View style={styles.section}>
        <Text style={styles.sectionHeader}>Events</Text>
        <Text style={styles.eventHeader}>
          {selectedDate ? `Events on ${selectedDate}` : 'Select a date to view events'}
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
          <Text style={styles.noEvents}>No events for this day.</Text>
        )}
      </View>

      {/* Attendance Section */}
      <View style={styles.section}>
        <Text style={styles.sectionHeader}>Attendance</Text>
        <Text style={styles.attendanceText}>
          {selectedDate
            ? `Attendance on ${selectedDate}: ${attendance[selectedDate] || 'No record'}`
            : 'Select a date to view attendance.'}
        </Text>
      </View>

      {/* Timetable Section */}
      <View style={styles.section}>
        <Text style={styles.sectionHeader}>Timetable</Text>
        {Object.entries(timetable).map(([day, subjects]) => (
          <View key={day} style={styles.timetableDay}>
            <Text style={styles.timetableDayHeader}>{day}</Text>
            {subjects.map((subject, index) => (
              <View key={index} style={styles.timetableItem}>
                <Text style={styles.timetableSubject}>{subject.subject}</Text>
                <Text style={styles.timetableTime}>{subject.time}</Text>
              </View>
            ))}
          </View>
        ))}
      </View>
    </ScrollView>
  );
};

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#f9f9f9',
  },
  section: {
    padding: 16,
    backgroundColor: '#fff',
    borderTopWidth: 1,
    borderTopColor: '#ddd',
    marginBottom: 10,
  },
  sectionHeader: {
    fontSize: 18,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  eventHeader: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 10,
  },
  eventItem: {
    backgroundColor: '#f2f2f2',
    padding: 10,
    marginBottom: 8,
    borderRadius: 5,
  },
  eventTitle: {
    fontSize: 14,
    fontWeight: 'bold',
  },
  eventTime: {
    fontSize: 12,
    color: 'gray',
  },
  noEvents: {
    fontSize: 14,
    color: 'gray',
  },
  attendanceText: {
    fontSize: 16,
  },
  timetableDay: {
    marginBottom: 15,
  },
  timetableDayHeader: {
    fontSize: 16,
    fontWeight: 'bold',
    marginBottom: 8,
  },
  timetableItem: {
    flexDirection: 'row',
    justifyContent: 'space-between',
    marginBottom: 5,
  },
  timetableSubject: {
    fontSize: 14,
  },
  timetableTime: {
    fontSize: 14,
    color: 'gray',
  },
});

export default CalendarScreen;
