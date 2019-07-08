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

import com.fr.projetMedical.dto.BulletinSalaireDto;
import com.fr.projetMedical.model.BulletinSalaire;
import com.fr.projetMedical.model.Medecin;
import com.fr.projetMedical.service.BulletinSalaireService;
import com.fr.projetMedical.service.MedecinService;

@RestController
@RequestMapping("/bulletinSalaire-api")
@CrossOrigin(origins = "http://localhost:4200")
public class BulletinSalaireApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private BulletinSalaireService bulletinSalaireService;
	
	@Autowired
	private MedecinService medecinService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<BulletinSalaire, BulletinSalaireDto> typeMap = modelMapper.getTypeMap(BulletinSalaire.class, BulletinSalaireDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<BulletinSalaire, BulletinSalaireDto>() {
				@Override
				protected void configure() {
					map().setIdBulletinSalaire(source.getIdBulletinSalaire());
					map().setIdMedecin(source.getMedecin().getIdMedecin());
					map().setMontant(source.getMontant());
					map().setNomMedecin(source.getMedecin().getNom());
					map().setPrenomMedecin(source.getMedecin().getPrenom());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<BulletinSalaireDto, BulletinSalaire> typeMap = modelMapper.getTypeMap(BulletinSalaireDto.class, BulletinSalaire.class);
		if (typeMap == null) {
			
			Converter<Long, Medecin> converterIdMedecinToMedecin = new Converter<Long, Medecin>() {
				public Medecin convert(MappingContext<Long, Medecin> context) {
					return medecinService.findByIdMedecin(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdMedecinToMedecin);
			
			modelMapper.addMappings(new PropertyMap<BulletinSalaireDto, BulletinSalaire>() {
				@Override
				protected void configure() {
					map().setIdBulletinSalaire(source.getIdBulletinSalaire());
					using(converterIdMedecinToMedecin).map(source.getIdMedecin(),destination.getMedecin());
					map().setMontant(source.getMontant());
				}
			});
		}
	}

	private BulletinSalaireDto convertBulletinSalaireToBulletinSalaireDto(BulletinSalaire bulletinSalaire) {
		definePropertyMap1();
		BulletinSalaireDto bulletinSalaireDto = modelMapper.map(bulletinSalaire, BulletinSalaireDto.class);
		return bulletinSalaireDto;
	}

	private List<BulletinSalaireDto> convertBulletinSalairesToBulletinSalairesDto(List<BulletinSalaire> listeBulletinSalaires) {
		definePropertyMap1();
		List<BulletinSalaireDto> listeBulletinSalairesDto = new ArrayList<BulletinSalaireDto>();
		for (BulletinSalaire a : listeBulletinSalaires) {
			listeBulletinSalairesDto.add(convertBulletinSalaireToBulletinSalaireDto(a));
		}
		return listeBulletinSalairesDto;
	}

	private BulletinSalaire convertBulletinSalaireDtoToBulletinSalaire(BulletinSalaireDto bulletinSalaireDto) {
		definePropertyMap2();
		BulletinSalaire bulletinSalaire = modelMapper.map(bulletinSalaireDto, BulletinSalaire.class);
		return bulletinSalaire;
	}

	private List<BulletinSalaire> convertBulletinSalairesDtoToBulletinSalaires(List<BulletinSalaireDto> listeBulletinSalairesDto) {
		definePropertyMap2();
		List<BulletinSalaire> listeBulletinSalaires = new ArrayList<BulletinSalaire>();
		for (BulletinSalaireDto a : listeBulletinSalairesDto) {
			listeBulletinSalaires.add(convertBulletinSalaireDtoToBulletinSalaire(a));
		}
		return listeBulletinSalaires;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<BulletinSalaireDto> getBulletinSalaires() {
		return convertBulletinSalairesToBulletinSalairesDto(bulletinSalaireService.findAll());
	}

	@GetMapping("/bulletinSalaire")
	public BulletinSalaireDto getBulletinSalaire(@RequestParam("idBulletinSalaire") Long id) {
		return convertBulletinSalaireToBulletinSalaireDto(bulletinSalaireService.findByIdBulletinSalaire(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<BulletinSalaireDto> addBulletinSalaire(@RequestBody BulletinSalaireDto bulletinSalaireDto) {
		BulletinSalaire bulletinSalaire = convertBulletinSalaireDtoToBulletinSalaire(bulletinSalaireDto);
		bulletinSalaireService.add(bulletinSalaire);
		bulletinSalaireDto = convertBulletinSalaireToBulletinSalaireDto(bulletinSalaireService.findByIdBulletinSalaire(bulletinSalaire.getIdBulletinSalaire()));
		return new ResponseEntity<BulletinSalaireDto>(bulletinSalaireDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<BulletinSalaireDto> updateBulletinSalaire(@RequestBody BulletinSalaireDto bulletinSalaireDto) {
		BulletinSalaire bulletinSalaire = convertBulletinSalaireDtoToBulletinSalaire(bulletinSalaireDto);
		bulletinSalaireService.update(bulletinSalaire);
		bulletinSalaireDto = convertBulletinSalaireToBulletinSalaireDto(bulletinSalaireService.findByIdBulletinSalaire(bulletinSalaire.getIdBulletinSalaire()));
		return new ResponseEntity<BulletinSalaireDto>(bulletinSalaireDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeBulletinSalaires(@RequestBody List<BulletinSalaireDto> listeBulletinSalairesDto) {
		List<BulletinSalaire> listeBulletinSalaires = convertBulletinSalairesDtoToBulletinSalaires(listeBulletinSalairesDto);
		bulletinSalaireService.delete(listeBulletinSalaires);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteBulletinSalaireById(@RequestParam("idBulletinSalaire") Long id) {
		bulletinSalaireService.deleteById(id);
		return HttpStatus.OK;
	}

}
