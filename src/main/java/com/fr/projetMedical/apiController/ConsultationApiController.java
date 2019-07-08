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

import com.fr.projetMedical.dto.ConsultationDto;
import com.fr.projetMedical.model.Consultation;
import com.fr.projetMedical.model.DossierPatient;
import com.fr.projetMedical.model.Facture;
import com.fr.projetMedical.model.Medecin;
import com.fr.projetMedical.service.ConsultationService;
import com.fr.projetMedical.service.DossierPatientService;
import com.fr.projetMedical.service.FactureService;
import com.fr.projetMedical.service.MedecinService;

@RestController
@RequestMapping("/consultation-api")
@CrossOrigin(origins = "http://localhost:4200")
public class ConsultationApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private ConsultationService consultationService;
	
	@Autowired
	private MedecinService medecinService;
	
	@Autowired
	private DossierPatientService dossierPatientService;
	
	@Autowired
	private FactureService factureService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Consultation, ConsultationDto> typeMap = modelMapper.getTypeMap(Consultation.class, ConsultationDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Consultation, ConsultationDto>() {
				@Override
				protected void configure() {
					map().setIdConsultation(source.getIdConsultation());
					map().setDate(source.getDate());
					map().setEffectuee(source.isEffectuee());
					map().setAnnulee(source.isAnnulee());
					map().setIdMedecin(source.getMedecin().getIdMedecin());
					map().setPrenomMedecin(source.getMedecin().getPrenom());
					map().setNomMedecin(source.getMedecin().getNom());
					map().setIdPatient(source.getDossierPatient().getPatient().getIdPatient());
					map().setPrenomPatient(source.getDossierPatient().getPatient().getPrenom());
					map().setNomPatient(source.getDossierPatient().getPatient().getNom());
					map().setIdDossierPatient(source.getDossierPatient().getIdDossierPatient());
					map().setIdFacture(source.getFacture().getIdFacture());
					map().setFacturePayee(source.getFacture().isPayee());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<ConsultationDto, Consultation> typeMap = modelMapper.getTypeMap(ConsultationDto.class, Consultation.class);
		if (typeMap == null) {
			
			Converter<Long, Medecin> converterIdMedecinToMedecin = new Converter<Long, Medecin>() {
				public Medecin convert(MappingContext<Long, Medecin> context) {
					return medecinService.findByIdMedecin(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdMedecinToMedecin);
			
			Converter<Long, DossierPatient> converterIdDossierPatientToDossierPatient = new Converter<Long, DossierPatient>() {
				public DossierPatient convert(MappingContext<Long, DossierPatient> context) {
					return dossierPatientService.findByIdDossierPatient(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdDossierPatientToDossierPatient);
			
			Converter<Long, Facture> converterIdFactureToFacture = new Converter<Long, Facture>() {
				public Facture convert(MappingContext<Long, Facture> context) {
					return factureService.findByIdFacture(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdFactureToFacture);
			
			modelMapper.addMappings(new PropertyMap<ConsultationDto, Consultation>() {
				@Override
				protected void configure() {
					map().setIdConsultation(source.getIdConsultation());
					map().setDate(source.getDate());
					map().setEffectuee(source.isEffectuee());
					map().setAnnulee(source.isAnnulee());
					using(converterIdMedecinToMedecin).map(source.getIdMedecin(),destination.getMedecin());
					using(converterIdDossierPatientToDossierPatient).map(source.getIdDossierPatient(),destination.getDossierPatient());
					using(converterIdFactureToFacture).map(source.getIdFacture(),destination.getFacture());
				}
			});
		}
	}

	private ConsultationDto convertConsultationToConsultationDto(Consultation consultation) {
		definePropertyMap1();
		ConsultationDto consultationDto = modelMapper.map(consultation, ConsultationDto.class);
		return consultationDto;
	}

	private List<ConsultationDto> convertConsultationsToConsultationsDto(List<Consultation> listeConsultations) {
		definePropertyMap1();
		List<ConsultationDto> listeConsultationsDto = new ArrayList<ConsultationDto>();
		for (Consultation a : listeConsultations) {
			listeConsultationsDto.add(convertConsultationToConsultationDto(a));
		}
		return listeConsultationsDto;
	}

	private Consultation convertConsultationDtoToConsultation(ConsultationDto consultationDto) {
		definePropertyMap2();
		Consultation consultation = modelMapper.map(consultationDto, Consultation.class);
		return consultation;
	}

	private List<Consultation> convertConsultationsDtoToConsultations(List<ConsultationDto> listeConsultationsDto) {
		definePropertyMap2();
		List<Consultation> listeConsultations = new ArrayList<Consultation>();
		for (ConsultationDto a : listeConsultationsDto) {
			listeConsultations.add(convertConsultationDtoToConsultation(a));
		}
		return listeConsultations;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<ConsultationDto> getConsultations() {
		return convertConsultationsToConsultationsDto(consultationService.findAll());
	}

	@GetMapping("/consultation")
	public ConsultationDto getConsultation(@RequestParam("idConsultation") Long id) {
		return convertConsultationToConsultationDto(consultationService.findByIdConsultation(id));
	}
	
	@GetMapping("/listInDossierPatient")
	public List<ConsultationDto> getConsultationsInDossierPatient(@RequestParam("idDossierPatient") Long id) {
		return convertConsultationsToConsultationsDto(consultationService.findByIdDossierPatient(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<ConsultationDto> addConsultation(@RequestBody ConsultationDto consultationDto) {
		Consultation consultation = convertConsultationDtoToConsultation(consultationDto);
		consultationService.add(consultation);
		consultationDto = convertConsultationToConsultationDto(consultationService.findByIdConsultation(consultation.getIdConsultation()));
		return new ResponseEntity<ConsultationDto>(consultationDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<ConsultationDto> updateConsultation(@RequestBody ConsultationDto consultationDto) {
		Consultation consultation = convertConsultationDtoToConsultation(consultationDto);
		consultationService.update(consultation);
		consultationDto = convertConsultationToConsultationDto(consultationService.findByIdConsultation(consultation.getIdConsultation()));
		return new ResponseEntity<ConsultationDto>(consultationDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeConsultations(@RequestBody List<ConsultationDto> listeConsultationsDto) {
		List<Consultation> listeConsultations = convertConsultationsDtoToConsultations(listeConsultationsDto);
		consultationService.delete(listeConsultations);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteConsultationById(@RequestParam("idConsultation") Long id) {
		consultationService.deleteById(id);
		return HttpStatus.OK;
	}

}
