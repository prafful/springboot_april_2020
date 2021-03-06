package com.example.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.FriendEntity;
import com.example.pojo.Friend;
import com.example.service.FriendService;

@RestController
public class WelcomeRestController {

	@Autowired
	private FriendService friendService;
	
	@RequestMapping("/")
	public String welcome() {
		
		/*
		 * FriendEntity fe = new FriendEntity(); fe.setFirstName("MLANN");
		 * fe.setLastName("AI");
		 * 
		 * FriendProfileEntity fpe = new FriendProfileEntity();
		 * fpe.setLocation("ChenNai"); fpe.setYears(8);
		 * 
		 * fe.setFriendProfileEntity(fpe);
		 * 
		 * friendProfileRepository.save(fpe); friendRepository.saveAndFlush(fe);
		 */
		
		
		return "Hello from One to One!!!!Saved!!!!";
	}
	
	//List<FriendEntity>
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	//@PostMapping("/add")
	public List<Friend> addFriend(@RequestBody Friend friend) {
		return friendService.addFriend(friend);
	}
	
	@RequestMapping("/all")
	public List<Friend> getAllFriends(){
		return friendService.getAllFriends();
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
	public Friend updateFriend(@PathVariable Integer id, @RequestBody Friend friend) {
		return friendService.updateFriend(id, friend);
	}
	
	
	@RequestMapping (value = "/update/{id}", method = RequestMethod.PATCH)
	public Friend updateFriendPatch(@PathVariable Integer id, @RequestBody Friend friend) {
		return friendService.updateFriendPatch(id, friend);
	}
	
	@RequestMapping (value = "/delete/{id}", method = RequestMethod.DELETE)
	public Friend deleteFriend(@PathVariable Integer id) {
		return friendService.deleteFriend(id);
	}
	
	
	
}
