package com.fr.projetMedical.apiController;

import java.util.ArrayList;
import java.util.Date;
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

import com.fr.projetMedical.dto.DossierPatientDto;
import com.fr.projetMedical.model.Consultation;
import com.fr.projetMedical.model.DossierPatient;
import com.fr.projetMedical.model.Maladie;
import com.fr.projetMedical.model.Patient;
import com.fr.projetMedical.service.ConsultationService;
import com.fr.projetMedical.service.DossierPatientService;
import com.fr.projetMedical.service.MaladieService;
import com.fr.projetMedical.service.PatientService;

@RestController
@RequestMapping("/dossierPatient-api")
@CrossOrigin(origins = "http://localhost:4200")
public class DossierPatientApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private DossierPatientService dossierPatientService;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private PatientService patientService;
	
	@Autowired
	private MaladieService maladieService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :	
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<DossierPatient, DossierPatientDto> typeMap = modelMapper.getTypeMap(DossierPatient.class, DossierPatientDto.class);
		if (typeMap == null) {
			Converter<List<Consultation>, List<Long>> converterListeConsultationsToListeIdConsultation = new Converter<List<Consultation>, List<Long>>() {
				public List<Long> convert(MappingContext<List<Consultation>, List<Long>> context) {
					List<Long> listeIdConsultation = new ArrayList<Long>();
					for (Consultation c : context.getSource()) {
						listeIdConsultation.add(c.getIdConsultation());
					}
					return  listeIdConsultation;
				}
			};
			modelMapper.addConverter(converterListeConsultationsToListeIdConsultation);
			
			Converter<List<Consultation>, List<Date>> converterListeConsultationsToListeDateConsultation = new Converter<List<Consultation>, List<Date>>() {
				public List<Date> convert(MappingContext<List<Consultation>, List<Date>> context) {
					List<Date> listeDateConsultation = new ArrayList<Date>();
					for (Consultation c : context.getSource()) {
						listeDateConsultation.add(c.getDate());
					}
					return  listeDateConsultation;
				}
			};
			modelMapper.addConverter(converterListeConsultationsToListeDateConsultation);
			
			Converter<List<Maladie>, List<Long>> converterListeMaladiesToListeIdMaladie = new Converter<List<Maladie>, List<Long>>() {
				public List<Long> convert(MappingContext<List<Maladie>, List<Long>> context) {
					List<Long> listeIdMaladie = new ArrayList<Long>();
					for (Maladie m : context.getSource()) {
						listeIdMaladie.add(m.getIdMaladie());
					}
					return  listeIdMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeIdMaladie);
			
			Converter<List<Maladie>, List<String>> converterListeMaladiesToListeNomMaladie = new Converter<List<Maladie>, List<String>>() {
				public List<String> convert(MappingContext<List<Maladie>, List<String>> context) {
					List<String> listeNomMaladie = new ArrayList<String>();
					for (Maladie m : context.getSource()) {
						listeNomMaladie.add(m.getNom());
					}
					return  listeNomMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeNomMaladie);
			
			Converter<List<Maladie>, List<Date>> converterListeMaladiesToListeDateDebutMaladie = new Converter<List<Maladie>, List<Date>>() {
				public List<Date> convert(MappingContext<List<Maladie>, List<Date>> context) {
					List<Date> listeDateDebutMaladie = new ArrayList<Date>();
					for (Maladie m : context.getSource()) {
						listeDateDebutMaladie.add(m.getDateDebut());
					}
					return  listeDateDebutMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeDateDebutMaladie);
			
			Converter<List<Maladie>, List<Date>> converterListeMaladiesToListeDateFinMaladie = new Converter<List<Maladie>, List<Date>>() {
				public List<Date> convert(MappingContext<List<Maladie>, List<Date>> context) {
					List<Date> listeDateFinMaladie = new ArrayList<Date>();
					for (Maladie m : context.getSource()) {
						listeDateFinMaladie.add(m.getDateFin());
					}
					return  listeDateFinMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeDateFinMaladie);
			
			Converter<List<Maladie>, List<String>> converterListeMaladiesToListeTraitementEffectueMaladie = new Converter<List<Maladie>, List<String>>() {
				public List<String> convert(MappingContext<List<Maladie>, List<String>> context) {
					List<String> listeTraitementEffectueMaladie = new ArrayList<String>();
					for (Maladie m : context.getSource()) {
						listeTraitementEffectueMaladie.add(m.getTraitementEffectue());
					}
					return  listeTraitementEffectueMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeTraitementEffectueMaladie);
			
			Converter<List<Maladie>, List<String>> converterListeMaladiesToListeInformationsSupplementairesMaladie = new Converter<List<Maladie>, List<String>>() {
				public List<String> convert(MappingContext<List<Maladie>, List<String>> context) {
					List<String> listeInformationsSupplementairesMaladie = new ArrayList<String>();
					for (Maladie m : context.getSource()) {
						listeInformationsSupplementairesMaladie.add(m.getInformationsSupplementaires());
					}
					return  listeInformationsSupplementairesMaladie;
				}
			};
			modelMapper.addConverter(converterListeMaladiesToListeInformationsSupplementairesMaladie);
			
			modelMapper.addMappings(new PropertyMap<DossierPatient, DossierPatientDto>() {
				@Override
				protected void configure() {
					map().setIdDossierPatient(source.getIdDossierPatient());
					using(converterListeConsultationsToListeIdConsultation).map(source.getListeConsultations(), destination.getListeIdConsultation());
					using(converterListeConsultationsToListeDateConsultation).map(source.getListeConsultations(), destination.getListeDateConsultation());
					map().setIdPatient(source.getPatient().getIdPatient());
					map().setPrenomPatient(source.getPatient().getPrenom());
					map().setNomPatient(source.getPatient().getNom());
					using(converterListeMaladiesToListeIdMaladie).map(source.getListeMaladies(),destination.getListeIdMaladie());
					using(converterListeMaladiesToListeNomMaladie).map(source.getListeMaladies(),destination.getListeNomMaladie());
					using(converterListeMaladiesToListeDateDebutMaladie).map(source.getListeMaladies(),destination.getListeDateDebutMaladie());
					using(converterListeMaladiesToListeDateFinMaladie).map(source.getListeMaladies(),destination.getListeDateFinMaladie());
					using(converterListeMaladiesToListeTraitementEffectueMaladie).map(source.getListeMaladies(),destination.getListeTraitementEffectueMaladie());
					using(converterListeMaladiesToListeInformationsSupplementairesMaladie).map(source.getListeMaladies(),destination.getListeInformationsSupplementairesMaladie());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<DossierPatientDto, DossierPatient> typeMap = modelMapper.getTypeMap(DossierPatientDto.class, DossierPatient.class);
		if (typeMap == null) {
			
			Converter<List<Long>, List<Consultation>> converterListeIdConsultationToListeConsultations = new Converter<List<Long>, List<Consultation>>() {
				public List<Consultation> convert(MappingContext<List<Long>, List<Consultation>> context) {
					List<Consultation> listeConsultations = new ArrayList<Consultation>();
					for (Long idConsultation : context.getSource()) {
						listeConsultations.add(consultationService.findByIdConsultation(idConsultation));
					}
					return  listeConsultations;
				}
			};
			modelMapper.addConverter(converterListeIdConsultationToListeConsultations);
			
			Converter<Long, Patient> converterIdPatientToPatient = new Converter<Long, Patient>() {
				public Patient convert(MappingContext<Long, Patient> context) {
					return patientService.findByIdPatient(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdPatientToPatient);
			
			Converter<List<Long>, List<Maladie>> converterListeIdMaladieToListeMaladies = new Converter<List<Long>, List<Maladie>>() {
				public List<Maladie> convert(MappingContext<List<Long>, List<Maladie>> context) {
					List<Maladie> listeMaladies = new ArrayList<Maladie>();
					for (Long idMaladie : context.getSource()) {
						listeMaladies.add(maladieService.findByIdMaladie(idMaladie));
					}
					return  listeMaladies;
				}
			};
			modelMapper.addConverter(converterListeIdMaladieToListeMaladies);
			
			modelMapper.addMappings(new PropertyMap<DossierPatientDto, DossierPatient>() {
				@Override
				protected void configure() {
					map().setIdDossierPatient(source.getIdDossierPatient());
					using(converterListeIdConsultationToListeConsultations).map(source.getListeIdConsultation(),destination.getListeConsultations());
					using(converterIdPatientToPatient).map(source.getIdPatient(),destination.getPatient());
					using(converterListeIdMaladieToListeMaladies).map(source.getListeIdMaladie(),destination.getListeMaladies());
				}
			});
		}
	}

	private DossierPatientDto convertDossierPatientToDossierPatientDto(DossierPatient dossierPatient) {
		definePropertyMap1();
		DossierPatientDto dossierPatientDto = modelMapper.map(dossierPatient, DossierPatientDto.class);
		return dossierPatientDto;
	}

	private List<DossierPatientDto> convertDossierPatientsToDossierPatientsDto(List<DossierPatient> listeDossierPatients) {
		definePropertyMap1();
		List<DossierPatientDto> listeDossierPatientsDto = new ArrayList<DossierPatientDto>();
		for (DossierPatient a : listeDossierPatients) {
			listeDossierPatientsDto.add(convertDossierPatientToDossierPatientDto(a));
		}
		return listeDossierPatientsDto;
	}

	private DossierPatient convertDossierPatientDtoToDossierPatient(DossierPatientDto dossierPatientDto) {
		definePropertyMap2();
		DossierPatient dossierPatient = modelMapper.map(dossierPatientDto, DossierPatient.class);
		return dossierPatient;
	}

	private List<DossierPatient> convertDossierPatientsDtoToDossierPatients(List<DossierPatientDto> listeDossierPatientsDto) {
		definePropertyMap2();
		List<DossierPatient> listeDossierPatients = new ArrayList<DossierPatient>();
		for (DossierPatientDto a : listeDossierPatientsDto) {
			listeDossierPatients.add(convertDossierPatientDtoToDossierPatient(a));
		}
		return listeDossierPatients;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<DossierPatientDto> getDossierPatients() {
		return convertDossierPatientsToDossierPatientsDto(dossierPatientService.findAll());
	}

	@GetMapping("/dossierPatient")
	public DossierPatientDto getDossierPatient(@RequestParam("idDossierPatient") Long id) {
		return convertDossierPatientToDossierPatientDto(dossierPatientService.findByIdDossierPatient(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<DossierPatientDto> addDossierPatient(@RequestBody DossierPatientDto dossierPatientDto) {
		DossierPatient dossierPatient = convertDossierPatientDtoToDossierPatient(dossierPatientDto);
		dossierPatientService.add(dossierPatient);
		dossierPatientDto = convertDossierPatientToDossierPatientDto(dossierPatientService.findByIdDossierPatient(dossierPatient.getIdDossierPatient()));
		return new ResponseEntity<DossierPatientDto>(dossierPatientDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<DossierPatientDto> updateDossierPatient(@RequestBody DossierPatientDto dossierPatientDto) {
		DossierPatient dossierPatient = convertDossierPatientDtoToDossierPatient(dossierPatientDto);
		dossierPatientService.update(dossierPatient);
		dossierPatientDto = convertDossierPatientToDossierPatientDto(dossierPatientService.findByIdDossierPatient(dossierPatient.getIdDossierPatient()));
		return new ResponseEntity<DossierPatientDto>(dossierPatientDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeDossierPatients(@RequestBody List<DossierPatientDto> listeDossierPatientsDto) {
		List<DossierPatient> listeDossierPatients = convertDossierPatientsDtoToDossierPatients(listeDossierPatientsDto);
		dossierPatientService.delete(listeDossierPatients);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteDossierPatientById(@RequestParam("idDossierPatient") Long id) {
		dossierPatientService.deleteById(id);
		return HttpStatus.OK;
	}

}
