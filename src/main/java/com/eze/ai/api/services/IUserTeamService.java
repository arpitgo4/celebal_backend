package com.eze.ai.api.services;

import java.util.List;

import com.eze.ai.api.models.UserTeam;

public interface IUserTeamService {
	void addUserTeamDetails(UserTeam team);
	UserTeam getTeamDetailsById(int userId);
	List<UserTeam> getAllTeamDetails();
	void updateTeam(UserTeam team);
	void deleteTeam(int userId);
}
