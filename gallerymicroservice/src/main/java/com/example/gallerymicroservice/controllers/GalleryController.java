package com.example.gallerymicroservice.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import com.example.gallerymicroservice.model.Gallery;
import com.example.gallerymicroservice.model.Image;

@Controller
@RequestMapping("/")
public class GalleryController {
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private Environment env;
	
	@RequestMapping("/")
	public String home()
	{
		return "Gallery Service Working On The Port :"+env.getProperty("local.server.port");
	}
	
	@RequestMapping("/{id}")
	public Gallery getgallery(@PathVariable final int id)
	{
		Gallery gallery=new Gallery();
		gallery.setId(id);
		
		List<Image> images = (List<Image>) restTemplate.getForObject("http://image-service/images/", Image.class);
		gallery.setImages(images);
	
		return gallery;
	}

}
