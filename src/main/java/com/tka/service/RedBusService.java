package com.tka.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tka.entity.Bus;
import com.tka.entity.User;
import com.tka.repo.BusRepository;
import com.tka.repo.UserRepository;

@Service
public class RedBusService {

    @Autowired 
    private UserRepository userRepo;
    
    @Autowired 
    private BusRepository busRepo;

    public User login(String email, String password) {
        User u = userRepo.findByEmail(email);
        if(u != null && u.getPassword().equals(password)) {
            return u;
        }
        return null;
    }

    public String saveUser(User user) {
        if (userRepo.findByEmail(user.getEmail()) != null) {
            return "Email already exists!";
        }
        userRepo.save(user);
        return "User registered successfully";
    }

    public List<Bus> searchBuses(String from, String to) {
        return busRepo.findBySourceAndDestination(from, to);
    }

    public boolean bookTicket(Long busId, int seatsToBook) {
        Bus bus = busRepo.findById(busId).orElse(null);
        
        if (bus != null && bus.getAvailableSeats() >= seatsToBook) {
            bus.setAvailableSeats(bus.getAvailableSeats() - seatsToBook);
            busRepo.save(bus);
            return true;
        }
        return false;
    }

    public List<Bus> getAllBuses() {
        return busRepo.findAll();
    }
    
    public void saveBus(Bus bus) { 
        busRepo.save(bus); 
    }

    public void deleteBus(Long id) {
        busRepo.deleteById(id);
    }
    
    public List<Bus> findBuses(String from, String to) { // naam change kiya
        return busRepo.findBySourceAndDestination(from, to);
    }
}