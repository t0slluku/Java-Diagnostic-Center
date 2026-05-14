import java.io.*;
import java.util.*;

class FileManager {
	
    private HashMap<Integer,Doctor> doctors = new HashMap<>();
    private HashMap<Integer,Patient> patients = new HashMap<>();
    private HashMap<Integer,Appointment> appointments= new HashMap<>();
    private HashMap<Integer,Exam> exams= new HashMap<>();
	
    void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");

                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].trim();
                }

                //String type = tokens[0];
                if (filePath.equals("doctors.txt")) {
                    Doctor doctor = new Doctor(
							Integer.parseInt(tokens[0]),
                            tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4])
                    );

                    doctors.put(doctor.getID(), doctor);
                } else if (filePath.equals("patients.txt")) {
                    Patient patient = new Patient(
							Integer.parseInt(tokens[0]),
                            tokens[1],
                            tokens[2],
                            tokens[3]
                    );

                    patients.put(patient.getID(), patient);
                } else if (filePath.equals("exams.txt")) {
                    String examType = tokens[1];
                    switch (examType) {
                        case "Imaging":
                            imagingExam imagingExam = new imagingExam(
									Integer.parseInt(tokens[0]),
                                    tokens[1],
                                    tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    tokens[6]
                            );
                            exams.put(imagingExam.getCode(), imagingExam);
                            break;
                        case "Microbiological":
                            microbiologicalExam microbiologicalExam = new microbiologicalExam(
									Integer.parseInt(tokens[0]),
                                    tokens[1],
                                    tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    tokens[6]
                            );
                            exams.put(microbiologicalExam.getCode(), microbiologicalExam);
                            break;
                        case "Specialized" : 
                            specializedExam specializedExam = new specializedExam(
									Integer.parseInt(tokens[0]),
                                    tokens[1],
                                    tokens[2],
                                    Integer.parseInt(tokens[3]),
                                    Integer.parseInt(tokens[4]),
                                    Integer.parseInt(tokens[5]),
                                    tokens[6]
                            );
                            exams.put(specializedExam.getCode(), specializedExam);
                            break;
                    }
                } else if (filePath.equals("appointments.txt")) {
                    Appointment appointment = new Appointment(
							Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            Boolean.parseBoolean(tokens[3]),
                            tokens[4]
                    );
                    appointments.put(appointment.getAppointmentId(), appointment);
                }
            }
			reader.close(); // κλείσιμο αρχείου

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }

	    void storeFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            if (filePath.equals("doctors.txt")) {
                for (Doctor doctor : doctors.values()) {
                    writer.write("Doctor,"
                            + doctor.getID() + ","
                            + doctor.getName() + ","
                            + doctor.getPhone() + ","
                            + doctor.getSpecialty() + ","
                            + doctor.getYearsofExp());
                    writer.newLine();     
                }
            } else if (filePath.equals("patients.txt")) {
                for (Patient patient : patients.values()) {
                    writer.write("Patient,"
                            + patient.getID() + ","
                            + patient.getName() + ","
                            + patient.getPhone() + ","
                            + patient.getEmail());
                    writer.newLine();     
                }
            } else if (filePath.equals("exams.txt")) {
                for (Exam exam : exams.values()) {
                    String examType = exam.getExamCategory();
                    writer.write(examType + ","
                            + exam.getCode() + ","
                            + exam.getExamName() + ","
                            + exam.getMaxSlotsperDay() + ","
                            + exam.getIdDoctor() + ","
                            + exam.cost()); // initial akeraio kostos, den exei perasthei to fastResults
                    writer.newLine();
                }
            } else if (filePath.equals("appointments.txt")) {
                for (Appointment appointment : appointments.values()) {
                    writer.write("Appointment,"
                            + appointment.getAppointmentId() + ","
                            + appointment.getPatientId() + ","
                            + appointment.getExamId() + ","
                            + appointment.getFastResults() + ","
                            + appointment.getExamDate());
                    writer.newLine();
                }
            }
			writer.close(); // κλείσιμο αρχείου

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    } //storeFile


public HashMap<Integer,Doctor> getdoctors(){
    return doctors;
}

public HashMap<Integer,Exam> getexams(){
    return exams;
}

public HashMap<Integer,Appointment> getappointments(){
    return appointments;
}

public HashMap<Integer,Patient> getpatients(){
    return patients;
}
}
