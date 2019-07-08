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

import com.fr.projetMedical.dto.MaladieDto;
import com.fr.projetMedical.model.DossierPatient;
import com.fr.projetMedical.model.Maladie;
import com.fr.projetMedical.service.DossierPatientService;
import com.fr.projetMedical.service.MaladieService;

@RestController
@RequestMapping("/maladie-api")
@CrossOrigin(origins = "http://localhost:4200")
public class MaladieApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private MaladieService maladieService;
	
	@Autowired
	private DossierPatientService dossierPatientService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Maladie, MaladieDto> typeMap = modelMapper.getTypeMap(Maladie.class, MaladieDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Maladie, MaladieDto>() {
				@Override
				protected void configure() {
					map().setIdMaladie(source.getIdMaladie());
					map().setNom(source.getNom());
					map().setDateDebut(source.getDateDebut());
					map().setDateFin(source.getDateFin());
					map().setTraitementPreconise(source.getTraitementPreconise());
					map().setTraitementEffectue(source.getTraitementEffectue());
					map().setInformationsSupplementaires(source.getInformationsSupplementaires());
					map().setIdDossierPatient(source.getDossierPatient().getIdDossierPatient());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<MaladieDto, Maladie> typeMap = modelMapper.getTypeMap(MaladieDto.class, Maladie.class);
		if (typeMap == null) {
			
			Converter<Long, DossierPatient> converterIdDossierPatientToDossierPatient = new Converter<Long, DossierPatient>() {
				public DossierPatient convert(MappingContext<Long, DossierPatient> context) {
					return dossierPatientService.findByIdDossierPatient(context.getSource());
				}
			};
			modelMapper.addConverter(converterIdDossierPatientToDossierPatient);
			
			modelMapper.addMappings(new PropertyMap<MaladieDto, Maladie>() {
				@Override
				protected void configure() {
					map().setIdMaladie(source.getIdMaladie());
					map().setNom(source.getNom());
					map().setDateDebut(source.getDateDebut());
					map().setDateFin(source.getDateFin());
					map().setTraitementPreconise(source.getTraitementPreconise());
					map().setTraitementEffectue(source.getTraitementEffectue());
					map().setInformationsSupplementaires(source.getInformationsSupplementaires());
					using(converterIdDossierPatientToDossierPatient).map(source.getIdDossierPatient(),destination.getDossierPatient());
				}
			});
		}
	}

	private MaladieDto convertMaladieToMaladieDto(Maladie maladie) {
		definePropertyMap1();
		MaladieDto maladieDto = modelMapper.map(maladie, MaladieDto.class);
		return maladieDto;
	}

	private List<MaladieDto> convertMaladiesToMaladiesDto(List<Maladie> listeMaladies) {
		definePropertyMap1();
		List<MaladieDto> listeMaladiesDto = new ArrayList<MaladieDto>();
		for (Maladie a : listeMaladies) {
			listeMaladiesDto.add(convertMaladieToMaladieDto(a));
		}
		return listeMaladiesDto;
	}

	private Maladie convertMaladieDtoToMaladie(MaladieDto maladieDto) {
		definePropertyMap2();
		Maladie maladie = modelMapper.map(maladieDto, Maladie.class);
		return maladie;
	}

	private List<Maladie> convertMaladiesDtoToMaladies(List<MaladieDto> listeMaladiesDto) {
		definePropertyMap2();
		List<Maladie> listeMaladies = new ArrayList<Maladie>();
		for (MaladieDto a : listeMaladiesDto) {
			listeMaladies.add(convertMaladieDtoToMaladie(a));
		}
		return listeMaladies;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<MaladieDto> getMaladies() {
		return convertMaladiesToMaladiesDto(maladieService.findAll());
	}

	@GetMapping("/maladie")
	public MaladieDto getMaladie(@RequestParam("idMaladie") Long id) {
		return convertMaladieToMaladieDto(maladieService.findByIdMaladie(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<MaladieDto> addMaladie(@RequestBody MaladieDto maladieDto) {
		Maladie maladie = convertMaladieDtoToMaladie(maladieDto);
		maladieService.add(maladie);
		maladieDto = convertMaladieToMaladieDto(maladieService.findByIdMaladie(maladie.getIdMaladie()));
		return new ResponseEntity<MaladieDto>(maladieDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<MaladieDto> updateMaladie(@RequestBody MaladieDto maladieDto) {
		Maladie maladie = convertMaladieDtoToMaladie(maladieDto);
		maladieService.update(maladie);
		maladieDto = convertMaladieToMaladieDto(maladieService.findByIdMaladie(maladie.getIdMaladie()));
		return new ResponseEntity<MaladieDto>(maladieDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeMaladies(@RequestBody List<MaladieDto> listeMaladiesDto) {
		List<Maladie> listeMaladies = convertMaladiesDtoToMaladies(listeMaladiesDto);
		maladieService.delete(listeMaladies);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteMaladieById(@RequestParam("idMaladie") Long id) {
		maladieService.deleteById(id);
		return HttpStatus.OK;
	}

}
