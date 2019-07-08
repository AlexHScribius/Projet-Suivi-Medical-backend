package com.fr.projetMedical.apiController;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.TypeMap;
import org.modelmapper.convention.MatchingStrategies;
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

import com.fr.projetMedical.dto.AdministrationDto;
import com.fr.projetMedical.model.Administration;
import com.fr.projetMedical.service.AdministrationService;

@RestController
@RequestMapping("/administration-api")
@CrossOrigin(origins = "http://localhost:4200")
public class AdministrationApiController {

	////////////////////////////////////////////////////////////////
	// Autowired :
	@Autowired(required = false)
	private ModelMapper modelMapper;
	
	@Autowired
	private AdministrationService administrationService;

	////////////////////////////////////////////////////////////////
	// Méthodes ModelMapper :
	private void definePropertyMap1() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<Administration, AdministrationDto> typeMap = modelMapper.getTypeMap(Administration.class, AdministrationDto.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<Administration, AdministrationDto>() {
				@Override
				protected void configure() {
					map().setIdAdministration(source.getIdAdministration());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
				}
			});
		}
	}

	private void definePropertyMap2() {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		TypeMap<AdministrationDto, Administration> typeMap = modelMapper.getTypeMap(AdministrationDto.class, Administration.class);
		if (typeMap == null) {
			modelMapper.addMappings(new PropertyMap<AdministrationDto, Administration>() {
				@Override
				protected void configure() {
					map().setIdAdministration(source.getIdAdministration());
					map().setLogin(source.getLogin());
					map().setPwd(source.getPwd());
				}
			});
		}
	}

	private AdministrationDto convertAdministrationToAdministrationDto(Administration administration) {
		definePropertyMap1();
		AdministrationDto administrationDto = modelMapper.map(administration, AdministrationDto.class);
		return administrationDto;
	}

	private List<AdministrationDto> convertAdministrationsToAdministrationsDto(List<Administration> listeAdministrations) {
		definePropertyMap1();
		List<AdministrationDto> listeAdministrationsDto = new ArrayList<AdministrationDto>();
		for (Administration a : listeAdministrations) {
			listeAdministrationsDto.add(convertAdministrationToAdministrationDto(a));
		}
		return listeAdministrationsDto;
	}

	private Administration convertAdministrationDtoToAdministration(AdministrationDto administrationDto) {
		definePropertyMap2();
		Administration administration = modelMapper.map(administrationDto, Administration.class);
		return administration;
	}

	private List<Administration> convertAdministrationsDtoToAdministrations(List<AdministrationDto> listeAdministrationsDto) {
		definePropertyMap2();
		List<Administration> listeAdministrations = new ArrayList<Administration>();
		for (AdministrationDto a : listeAdministrationsDto) {
			listeAdministrations.add(convertAdministrationDtoToAdministration(a));
		}
		return listeAdministrations;
	}

	////////////////////////////////////////////////////////////////
	// Méthodes Controller :
	@GetMapping("/list")
	public List<AdministrationDto> getAdministrations() {
		return convertAdministrationsToAdministrationsDto(administrationService.findAll());
	}

	@GetMapping("/administration")
	public AdministrationDto getAdministration(@RequestParam("idAdministration") Long id) {
		return convertAdministrationToAdministrationDto(administrationService.findByIdAdministration(id));
	}

	@PostMapping(value = "/add")
	public ResponseEntity<AdministrationDto> addAdministration(@RequestBody AdministrationDto administrationDto) {
		Administration administration = convertAdministrationDtoToAdministration(administrationDto);
		administrationService.add(administration);
		administrationDto = convertAdministrationToAdministrationDto(administrationService.findByIdAdministration(administration.getIdAdministration()));
		return new ResponseEntity<AdministrationDto>(administrationDto, HttpStatus.OK);
	}

	@PutMapping(value = "/update")
	public ResponseEntity<AdministrationDto> updateAdministration(@RequestBody AdministrationDto administrationDto) {
		Administration administration = convertAdministrationDtoToAdministration(administrationDto);
		administrationService.update(administration);
		administrationDto = convertAdministrationToAdministrationDto(administrationService.findByIdAdministration(administration.getIdAdministration()));
		return new ResponseEntity<AdministrationDto>(administrationDto, HttpStatus.OK);
	}

	@PostMapping("/deleteList")
	public HttpStatus deleteListeAdministrations(@RequestBody List<AdministrationDto> listeAdministrationsDto) {
		List<Administration> listeAdministrations = convertAdministrationsDtoToAdministrations(listeAdministrationsDto);
		administrationService.delete(listeAdministrations);
		return HttpStatus.OK;
	}

	@DeleteMapping("/delete")
	public HttpStatus deleteAdministrationById(@RequestParam("idAdministration") Long id) {
		administrationService.deleteById(id);
		return HttpStatus.OK;
	}

}
