package de.predikant.conference.service.api;

import java.util.List;

import javax.ejb.Local;

import de.predikant.conference.service.exception.SpeakerHasTalkNotFoundException;
import de.predikant.conference.service.exception.SpeakerNotAvailableException;
import de.predikant.conference.service.model.Speaker;
import de.predikant.conference.service.model.SpeakerHasTalk;
import de.predikant.conference.service.model.Talk;

@Local
public interface SpeakerHasTalkService {

	void assign(Speaker speaker, Talk talk) throws SpeakerNotAvailableException;
	
	void unassign(Speaker speaker, Talk talk)
			throws SpeakerHasTalkNotFoundException;
	
	SpeakerHasTalk findSpeakerHasTalkBySpeakerAndTalk(Speaker speaker, Talk talk)
			throws SpeakerHasTalkNotFoundException;
	
	List<Speaker> findSpeakersByTalk(Talk talk);
	
	List<Talk> findTalksBySpeaker(Speaker speaker);
	
}
