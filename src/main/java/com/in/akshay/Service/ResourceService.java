package com.in.akshay.Service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.in.akshay.Entity.Resource;
import com.in.akshay.Repository.ResourceRepository;

@Service
public class ResourceService {
	
	@Autowired
	private ResourceRepository repo;
	
	public boolean regResource(Resource res) {
		// TODO Auto-generated method stub
		try {
             repo.save(res)   ;
			return true;
		}
		catch (Exception e) {
			// TODO: handle exception
			return false;
		}
	}
	
	 public List<Resource> getResourcesBySkillsAndExperience(String skills, int maxExperience) {
		 
		     List<String> skillList = Arrays.asList(skills.split("\\s*,\\s*"));
		     return repo.findAll().stream()
		                .filter(r -> r.getExperience() < maxExperience && Arrays.asList(r.getSkills().split("\\s*,\\s*")).containsAll(skillList)
		                ).collect(Collectors.toList());
	    }
	
	

}
