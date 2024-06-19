package com.orm.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.orm.Entity.ConfigurationProperty;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class FileReader {
	
	@Value("${app.upload.location}")
	private String foldername;
	
	@Autowired
	private ConfigurationProperty cp;
	
	@GetMapping("read/{filename}")
	public ResponseEntity<Resource> download(@PathVariable ("filename") String filename)
	{
		String FolderLocation=foldername;
		String filepath = FolderLocation+filename;
		
		FileSystemResource fs = new FileSystemResource(filepath);
		HttpHeaders hh = new HttpHeaders();
		hh.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		hh.setContentDispositionFormData("attachment", filename);
		
		log.info("data--"+cp);
		
		return new ResponseEntity<Resource>(fs,hh,HttpStatus.OK);
	}
	
}
