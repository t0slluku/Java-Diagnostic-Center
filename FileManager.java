import java.io.*;
import java.util.*;

class FileManager {
    HashMap<Integer, Doctor> doctors = new HashMap<>();
    HashMap<Integer, Patient> patients = new HashMap<>();

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
                            tokens[1],
                            tokens[2],
                            tokens[3],
                            Integer.parseInt(tokens[4])
                    );

                    doctors.put(doctor.getID(), doctor);
                } else if (filePath.equals("patients.txt")) {
                    Patient patient = new Patient(
                            tokens[1],
                            tokens[2],
                            tokens[3]
                    );

                    patients.put(patient.getID(), patient);
                } else if (filePath.equals("exams.txt")) {
                    // Διαχείριση αρχείου εξετάσεων
                }
            }
			reader.close(); // κλείσιμο αρχείου

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }



    void addDoctor(Doctor d) {
        doctors.put(d.getID(), d);
    }
}
