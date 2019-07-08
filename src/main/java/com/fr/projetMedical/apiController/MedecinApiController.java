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

import com.fr.projetMedical.dto.MedecinDto;
import com.fr.projetMedical.model.BulletinSalaire;
import com.fr.projetMedical.model.Consultation;
import com.fr.projetMedical.model.Medecin;
import com.fr.projetMedical.service.MedecinService;

@RestController
@RequestMapping("/medecin-api")
@CrossOrigin(origins = "http://localhost:4200")
public class MedecinApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private MedecinService medecinService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Medecin, MedecinDto> typeMap = modelMapper.getTypeMap(Medecin.class, MedecinDto.class);
		if (typeMap == null) {
			Converter<List<Consultation>, List<Long>> converterListeConsultationToListeIdConsultation = new Converter<List<Consultation>, List<Long>>() {
				public List<Long> convert(MappingContext<List<Consultation>, List<Long>> context) {
					List<Long> listeIdConsultation = new ArrayList<Long>();
					for (Consultation c : context.getSource()) {
						listeIdConsultation.add(c.getIdConsultation());
					}
					return  listeIdConsultation;
				}
			};
			modelMapper.addConverter(converterListeConsultationToListeIdConsultation);
			
			Converter<List<Consultation>, List<Date>> converterListeConsultationToListeDateConsultation = new Converter<List<Consultation>, List<Date>>() {
				public List<Date> convert(MappingContext<List<Consultation>, List<Date>> context) {
					List<Date> listeDateConsultation = new ArrayList<Date>();
					for (Consultation c : context.getSource()) {
						listeDateConsultation.add(c.getDate());
					}
					return  listeDateConsultation;
				}
			};
			modelMapper.addConverter(converterListeConsultationToListeDateConsultation);
			
			Converter<List<BulletinSalaire>, List<Long>> converterListeBulletinSalaireToListeIdBulletinSalaire = new Converter<List<BulletinSalaire>, List<Long>>() {
				public List<Long> convert(MappingContext<List<BulletinSalaire>, List<Long>> context) {
					List<Long> listeIdBulletinSalaire = new ArrayList<Long>();
					for (BulletinSalaire bs : context.getSource()) {
						listeIdBulletinSalaire.add(bs.getIdBulletinSalaire());
					}
					return  listeIdBulletinSalaire;
				}
			};
			modelMapper.addConverter(converterListeBulletinSalaireToListeIdBulletinSalaire);
			
			Converter<List<BulletinSalaire>, List<Double>> converterListeBulletinSalaireToListeMontantBulletinSalaire = new Converter<List<BulletinSalaire>, List<Double>>() {
				public List<Double> convert(MappingContext<List<BulletinSalaire>, List<Double>> context) {
					List<Double> listeMontantBulletinSalaire = new ArrayList<Double>();
					for (BulletinSalaire bs : context.getSource()) {
						listeMontantBulletinSalaire.add(bs.getMontant());
					}
					return  listeMontantBulletinSalaire;
				}
			};
			modelMapper.addConverter(converterListeBulletinSalaireToListeMontantBulletinSalaire);
			
			modelMapper.addMappings(new PropertyMap<Medecin, MedecinDto>() {
				@Override
				protected void configure() {
					map().setIdMedecin(source.getIdMedecin());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
					map().setNom(source.getNom());
					map().setPrenom(source.getPrenom());
					map().setAge(source.getAge());
					map().setAdresse(source.getAdresse());
					map().setMail(source.getMail());
					map().setTelephone(source.getTelephone());
					map().setSalaire(source.getSalaire());
					using(converterListeConsultationToListeIdConsultation).map(source.getListeConsultations(),destination.getListeIdConsultation());
					using(converterListeConsultationToListeDateConsultation).map(source.getListeConsultations(),destination.getListeDateConsultation());
					using(converterListeBulletinSalaireToListeIdBulletinSalaire).map(source.getListeBulletinSalaires(),destination.getListeIdBulletinSalaire());
					using(converterListeBulletinSalaireToListeMontantBulletinSalaire).map(source.getListeBulletinSalaires(),destination.getListeMontantBulletinSalaire());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<MedecinDto, Medecin> typeMap = modelMapper.getTypeMap(MedecinDto.class, Medecin.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<MedecinDto, Medecin>() {
				@Override
				protected void configure() {
					map().setIdMedecin(source.getIdMedecin());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
				}
			});
		}
	}

	private MedecinDto convertMedecinToMedecinDto(Medecin medecin) {
		definePropertyMap1();
		MedecinDto medecinDto = modelMapper.map(medecin, MedecinDto.class);
		return medecinDto;
	}

	private List<MedecinDto> convertMedecinsToMedecinsDto(List<Medecin> listeMedecins) {
		definePropertyMap1();
		List<MedecinDto> listeMedecinsDto = new ArrayList<MedecinDto>();
		for (Medecin a : listeMedecins) {
			listeMedecinsDto.add(convertMedecinToMedecinDto(a));
		}
		return listeMedecinsDto;
	}

	private Medecin convertMedecinDtoToMedecin(MedecinDto medecinDto) {
		definePropertyMap2();
		Medecin medecin = modelMapper.map(medecinDto, Medecin.class);
		return medecin;
	}

	private List<Medecin> convertMedecinsDtoToMedecins(List<MedecinDto> listeMedecinsDto) {
		definePropertyMap2();
		List<Medecin> listeMedecins = new ArrayList<Medecin>();
		for (MedecinDto a : listeMedecinsDto) {
			listeMedecins.add(convertMedecinDtoToMedecin(a));
		}
		return listeMedecins;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<MedecinDto> getMedecins() {
		return convertMedecinsToMedecinsDto(medecinService.findAll());
	}

	@GetMapping("/medecin")
	public MedecinDto getMedecin(@RequestParam("idMedecin") Long id) {
		return convertMedecinToMedecinDto(medecinService.findByIdMedecin(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<MedecinDto> addMedecin(@RequestBody MedecinDto medecinDto) {
		Medecin medecin = convertMedecinDtoToMedecin(medecinDto);
		medecinService.add(medecin);
		medecinDto = convertMedecinToMedecinDto(medecinService.findByIdMedecin(medecin.getIdMedecin()));
		return new ResponseEntity<MedecinDto>(medecinDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<MedecinDto> updateMedecin(@RequestBody MedecinDto medecinDto) {
		Medecin medecin = convertMedecinDtoToMedecin(medecinDto);
		medecinService.update(medecin);
		medecinDto = convertMedecinToMedecinDto(medecinService.findByIdMedecin(medecin.getIdMedecin()));
		return new ResponseEntity<MedecinDto>(medecinDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeMedecins(@RequestBody List<MedecinDto> listeMedecinsDto) {
		List<Medecin> listeMedecins = convertMedecinsDtoToMedecins(listeMedecinsDto);
		medecinService.delete(listeMedecins);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteMedecinById(@RequestParam("idMedecin") Long id) {
		medecinService.deleteById(id);
		return HttpStatus.OK;
	}

}
