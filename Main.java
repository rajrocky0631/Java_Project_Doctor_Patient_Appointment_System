import java.util.ArrayList;
import java.util.Scanner;

class Appointment {
    private String date;
    private String time;
    private String patientName;
    private String doctorName;

    public Appointment(String date, String time, String patientName, String doctorName) {
        this.date = date;
        this.time = time;
        this.patientName = patientName;
        this.doctorName = doctorName;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }
}

class Doctor {
    private String name;
    private String specialization;
    private ArrayList<Appointment> appointments;

    public Doctor(String name, String specialization) {
        this.name = name;
        this.specialization = specialization;
        this.appointments = new ArrayList<Appointment>();
    }

    public String getName() {
        return name;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void addAppointment(String date, String time, String patientName) {
        Appointment appointment = new Appointment(date, time, patientName, this.name);
        this.appointments.add(appointment);
    }

    public void displayAppointments() {
        System.out.println("Appointments for " + this.name + ":");
        for (Appointment appointment : appointments) {
            System.out.println("Date: " + appointment.getDate() + " Time: " + appointment.getTime() + " Patient: " + appointment.getPatientName());
        }
    }
}

class Patient {
    private String name;
    private ArrayList<Appointment> appointments;

    public Patient(String name) {
        this.name = name;
        this.appointments = new ArrayList<Appointment>();
    }

    public String getName() {
        return name;
    }

    public void addAppointment(String date, String time, String doctorName) {
        Appointment appointment = new Appointment(date, time, this.name, doctorName);
        this.appointments.add(appointment);
    }

    public void displayAppointments() {
        System.out.println("Appointments for " + this.name + ":");
        for (Appointment appointment : appointments) {
            System.out.println("Date: " + appointment.getDate() + " Time: " + appointment.getTime() + " Doctor: " + appointment.getDoctorName());
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
    
        System.out.println("Enter your name:");
        String patientName = input.nextLine();
    
        System.out.println("Enter the date of your appointment (YYYY-MM-DD):");
        String date = input.nextLine();
    
        System.out.println("Enter the time of your appointment (HH:MM AM/PM):");
        String time = input.nextLine();
    
        System.out.println("Choose a doctor from the list:");
        System.out.println("1. Dr. John Doe - Cardiology");
        System.out.println("2. Dr. Jane Smith - Pediatrics");
    
        int doctorChoice = input.nextInt();
        input.nextLine(); // consume the newline character
    
        String doctorName;
        if (doctorChoice == 1) {
            doctorName = "Dr. John Doe";
        } else {
            doctorName = "Dr. Jane Smith";
        }
    
        Doctor doctor = new Doctor(doctorName, "");
        Patient patient = new Patient(patientName);
    
        doctor.addAppointment(date, time, patient.getName());
        patient.addAppointment(date, time, doctor.getName());
    
        System.out.println("Appointment successfully booked.");
        doctor.displayAppointments();
        patient.displayAppointments();
    }
    
}