package br.com.amigooo.dao;

import java.util.List;

import br.com.amigooo.model.ActiveSession;

public interface ActiveSessionDao {
	public ActiveSession getActiveSession(Integer id);
	public List<ActiveSession> getActiveSessionList();
}
