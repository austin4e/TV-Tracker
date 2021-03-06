package com.tvtracker.model;

import java.io.Serializable;
import java.util.HashMap;

/**
 *
 * @authors Austin Forry, Daniel Muckerman, Chris Yealy, Austin Decker
 *
 */

/*
 * constructor
 */
public class MediaListProgress implements Serializable {
	private static final long serialVersionUID = 1L;

	private MediaProgress mediaProgress;
	private MediaList mediaList;
	
	/*
	 * initializes mediaList and mediaProgress
	 */
	public MediaListProgress() {
		this.mediaList = new MediaList();
		//MediaProgress takes a Media and Progress object and combines them
		//into a HashMap together, so Media can be tied to Progress
		this.mediaProgress = new MediaProgress(new HashMap<Media, Progress>());
	}
	
	/*
	 * sets MediaListProgress taking in a MediaList and MediaProgress object
	 */
	public MediaListProgress(MediaList mediaList, MediaProgress mediaProgress) {
		this.mediaList = mediaList;
		this.mediaProgress = mediaProgress;
	}
	
	/*
	 * adds media to the MediaList then adds media and creates a new Progress object for it
	 */
	public void addMedia(Media media, int episodesSeenInCurrentSeason, int episodesInCurrentSeason, int currentSeason) {
		mediaList.addMedia(media);
		mediaProgress.addMedia(media, new Progress(currentSeason, episodesSeenInCurrentSeason, episodesInCurrentSeason));
	}
	
	/*
	 * return current mediaProgress
	 */
	public Progress currentProgress(Media media) {
		return mediaProgress.getProgress(media);
	}
	
	/*
	 * return current media at index "number"
	 */
	public Media getMedia(int number) {
		return this.mediaList.getMedia(number);
	}
	
	/*
	 * set current mediaList
	 */
	public void setMediaList(MediaList mediaList) {
		this.mediaList = mediaList;
	}
	
	/*
	 * set current mediaProgress
	 */
	public void setMediaProgress(MediaProgress mediaProgress) {
		this.mediaProgress = mediaProgress;
	}
}
