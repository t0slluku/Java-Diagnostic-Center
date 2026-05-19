import java.io.*;
import java.util.*;

class FileManager {
	// The HashMaps
    private HashMap<Integer,Doctor> doctors = new HashMap<>();
    private HashMap<Integer,Patient> patients = new HashMap<>();
    private HashMap<Integer,Appointment> appointments= new HashMap<>();
    private HashMap<Integer,Exam> exams= new HashMap<>();
	// Reading files
    void loadFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] tokens = line.split(",");

                for (int i = 0; i < tokens.length; i++) {
                    tokens[i] = tokens[i].trim();
                }

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
                    
                    String examCategory = tokens[2];
                    
                    int code = Integer.parseInt(tokens[0]);
                    String examName = tokens[1];
                    String details = tokens[3];
                    int maxSlots = Integer.parseInt(tokens[4]);
                    int cost = Integer.parseInt(tokens[5]);
                    int doctorId = Integer.parseInt(tokens[6]);

                    switch (examCategory) {
                        case "Imaging": 
                            imagingExam imgExam = new imagingExam(code, examCategory, examName, maxSlots, cost, doctorId, details);
                            exams.put(imgExam.getCode(), imgExam);
                            break;
                            
                        case "Microbiological":
                            microbiologicalExam microExam = new microbiologicalExam(code, examCategory, examName, maxSlots, cost, doctorId, details);
                            exams.put(microExam.getCode(), microExam);
                            break;
                            
                        case "Specialized":
                            specializedExam specExam = new specializedExam(code, examCategory, examName, maxSlots, cost, doctorId, details);
                            exams.put(specExam.getCode(), specExam);
                            break;
                    }
                } else if (filePath.equals("appointments.txt")) {
                    Appointment appointment = new Appointment(
							Integer.parseInt(tokens[0]),
                            Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]),
                            Boolean.parseBoolean(tokens[3]),
                            tokens[4],
                            Boolean.parseBoolean(tokens[5])
                    );
                    appointments.put(appointment.getAppointmentId(), appointment);
                }
            }
			reader.close();

        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
    }
    // Saving files
	void storeFile(String filePath) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {

            if (filePath.equals("doctors.txt")) {
                for (Doctor doctor : doctors.values()) {
                    writer.write(
                            doctor.getID() + ","
                            + doctor.getName() + ","
                            + doctor.getPhone() + ","
                            + doctor.getSpecialty() + ","
                            + doctor.getYearsofExp());
                    writer.newLine();     
                }
            } else if (filePath.equals("patients.txt")) {
                for (Patient patient : patients.values()) {
                    writer.write(
                            patient.getID() + ","
                            + patient.getName() + ","
                            + patient.getPhone() + ","
                            + patient.getEmail());
                    writer.newLine();     
                }
            } else if (filePath.equals("exams.txt")) {
                for (Exam exam : exams.values()) {
                    String examType = exam.getExamCategory();
					if (examType.equals("Imaging")) {
                    writer.write(
                            exam.getCode() + ","
							+ exam.getExamName() + ","
							+ exam.getExamCategory()+","
                            +((imagingExam)exam).getMachineType()+","
                            + exam.getMaxSlotsperDay() + ","
							+ exam.cost() + ","
                            + exam.getIdDoctor());
                    writer.newLine();
					}
					
					if (examType.equals("Microbiological")){
					writer.write(
                            exam.getCode() + ","
							+ exam.getExamName() + ","
							+exam.getExamCategory()+","
                            + ((microbiologicalExam)exam).getSampleType()+","
                            + exam.getMaxSlotsperDay() + ","
							+ exam.cost() + ","
                            + exam.getIdDoctor());
                    writer.newLine();
					}
					
					if (examType.equals("Specialized")){
					  writer.write(
                            exam.getCode() + ","
							+ exam.getExamName() + ","
							+ exam.getExamCategory()+","
                            + ((specializedExam)exam).getSpecialty()+","
                            + exam.getMaxSlotsperDay() + ","
							+ exam.cost() + ","
                            + exam.getIdDoctor());
                    writer.newLine();
					}
                }
            } else if (filePath.equals("appointments.txt")) {
                for (Appointment appointment : appointments.values()) {
                    writer.write(
                            appointment.getAppointmentId() + ","
                            + appointment.getPatientId() + ","
                            + appointment.getExamId() + ","
                            + appointment.getFastResults() + ","
                            + appointment.getExamDate() + ","
                            + appointment.getCancelled());
                    writer.newLine();
                }
            }
			writer.close(); 

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }

    // Getters for the HashMaps
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
