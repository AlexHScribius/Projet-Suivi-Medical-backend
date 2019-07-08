package com.fr.projetMedical.apiController;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fr.projetMedical.dto.PatientDto;
import com.fr.projetMedical.model.DossierPatient;
import com.fr.projetMedical.model.Patient;
import com.fr.projetMedical.service.DossierPatientService;
import com.fr.projetMedical.service.PatientService;

@RestController
@RequestMapping("/patient-api")
@CrossOrigin(origins = "http://localhost:4200")
public class PatientApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private DossierPatientService dossierPatientService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Patient, PatientDto> typeMap = modelMapper.getTypeMap(Patient.class, PatientDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Patient, PatientDto>() {
				@Override
				protected void configure() {
					map().setIdPatient(source.getIdPatient());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
					map().setNom(source.getNom());
					map().setPrenom(source.getPrenom());
					map().setAge(source.getAge());
					map().setAdresse(source.getAdresse());
					map().setMail(source.getMail());
					map().setTelephone(source.getTelephone());
					map().setNumeroSecuriteSociale(source.getNumeroSecuriteSociale());
					map().setIdDossierPatient(source.getDossierPatient().getIdDossierPatient());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<PatientDto, Patient> typeMap = modelMapper.getTypeMap(PatientDto.class, Patient.class);
		if (typeMap == null) {
			
			Converter<Long, DossierPatient> converterIdDossierPatientToDossierPatient = new Converter<Long, DossierPatient>() {
				public DossierPatient convert(MappingContext<Long, DossierPatient> context) {
					return dossierPatientService.findByIdDossierPatient(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdDossierPatientToDossierPatient);
			
			modelMapper.addMappings(new PropertyMap<PatientDto, Patient>() {
				@Override
				protected void configure() {
					map().setIdPatient(source.getIdPatient());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
					map().setNom(source.getNom());
					map().setPrenom(source.getPrenom());
					map().setAge(source.getAge());
					map().setAdresse(source.getAdresse());
					map().setMail(source.getMail());
					map().setTelephone(source.getTelephone());
					map().setNumeroSecuriteSociale(source.getNumeroSecuriteSociale());
					using(converterIdDossierPatientToDossierPatient).map(source.getIdDossierPatient(),destination.getDossierPatient());
				}
			});
		}
	}

	private PatientDto convertPatientToPatientDto(Patient patient) {
		definePropertyMap1();
		PatientDto patientDto = modelMapper.map(patient, PatientDto.class);
		return patientDto;
	}

	private List<PatientDto> convertPatientsToPatientsDto(List<Patient> listePatients) {
		definePropertyMap1();
		List<PatientDto> listePatientsDto = new ArrayList<PatientDto>();
		for (Patient a : listePatients) {
			listePatientsDto.add(convertPatientToPatientDto(a));
		}
		return listePatientsDto;
	}

	private Patient convertPatientDtoToPatient(PatientDto patientDto) {
		definePropertyMap2();
		Patient patient = modelMapper.map(patientDto, Patient.class);
		return patient;
	}

	private List<Patient> convertPatientsDtoToPatients(List<PatientDto> listePatientsDto) {
		definePropertyMap2();
		List<Patient> listePatients = new ArrayList<Patient>();
		for (PatientDto a : listePatientsDto) {
			listePatients.add(convertPatientDtoToPatient(a));
		}
		return listePatients;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<PatientDto> getPatients() {
		return convertPatientsToPatientsDto(patientService.findAll());
	}

	@GetMapping("/patient")
	public PatientDto getPatient(@RequestParam("idPatient") Long id) {
		return convertPatientToPatientDto(patientService.findByIdPatient(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<PatientDto> addPatient(@RequestBody PatientDto patientDto) {
		Patient patient = convertPatientDtoToPatient(patientDto);
		patientService.add(patient);
		patientDto = convertPatientToPatientDto(patientService.findByIdPatient(patient.getIdPatient()));
		return new ResponseEntity<PatientDto>(patientDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<PatientDto> updatePatient(@RequestBody PatientDto patientDto) {
		Patient patient = convertPatientDtoToPatient(patientDto);
		patientService.update(patient);
		patientDto = convertPatientToPatientDto(patientService.findByIdPatient(patient.getIdPatient()));
		return new ResponseEntity<PatientDto>(patientDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListePatients(@RequestBody List<PatientDto> listePatientsDto) {
		List<Patient> listePatients = convertPatientsDtoToPatients(listePatientsDto);
		patientService.delete(listePatients);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deletePatientById(@RequestParam("idPatient") Long id) {
		patientService.deleteById(id);
		return HttpStatus.OK;
	}

}
