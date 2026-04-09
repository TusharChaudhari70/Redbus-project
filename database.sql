CREATE DATABASE redbus;

USE redbus;

CREATE TABLE buses (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    bus_name VARCHAR(255),
    source VARCHAR(255),
    destination VARCHAR(255),
    departure_time VARCHAR(50),
    price DOUBLE,
    bus_type VARCHAR(100),
    available_seats INT,
    distance_km INT
);

-- Insert sample data
INSERT INTO buses (bus_name, source, destination, departure_time, price, bus_type, available_seats, distance_km)
VALUES 
('Shivneri Express', 'Mumbai', 'Pune', '08:00 AM', 500, 'AC Seater', 30, 150),
('RedBus Sleeper', 'Mumbai', 'Goa', '10:00 PM', 1200, 'AC Sleeper', 20, 600),
('Pune Travels', 'Pune', 'Mumbai', '07:30 AM', 450, 'Non-AC Seater', 35, 150),
('Goa Night Rider', 'Pune', 'Goa', '09:00 PM', 900, 'AC Sleeper', 25, 450);
