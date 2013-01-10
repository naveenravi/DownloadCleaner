package com.naveen.dcleaner;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_MODIFY;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class Laucher {

	/*
	 * private static final String location =
	 * "C:\\Users\\Naveen\\Desktop\\Testing"; private static final String
	 * picture_location = "C:\\Users\\Naveen\\Desktop\\Pictures"; private static
	 * final String music_location = "C:\\Users\\Naveen\\Desktop\\Music";
	 * private static final String doc_location =
	 * "C:\\Users\\Naveen\\Desktop\\Docum";
	 */
	private enum extensions {
		// jpg(picture_location), mp3(music_location), doc(doc_location), docx(
		// doc_location), pdf(doc_location), gif(picture_location),
		// png(picture_location);
		jpg(cleanerGUI.getPicture_location()), mp3(cleanerGUI
				.getMusic_location()), doc(cleanerGUI.getDoc_location()), docx(
				cleanerGUI.getDoc_location()), pdf(cleanerGUI.getDoc_location()), gif(
				cleanerGUI.getPicture_location()), png(cleanerGUI
				.getPicture_location()), tmp("C:\\Users\\Naveen\\Downloads");

		private String custom_location;

		private extensions(String loc) {
			this.custom_location = loc;
		}

		private String getlocation() {
			return custom_location;
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("starting the app now....");

		cleanerGUI GUIObj = new cleanerGUI();	
		GUIObj.callLaunch(args);
		String prevFileName = null ;
		

		// Path mypath = Paths.get(location);
		Path mypath = Paths.get(cleanerGUI.getLocation());
		// creating a watcherservice
		try {
			System.out.println("creating a watcher service");
			WatchService wservice = mypath.getFileSystem().newWatchService();
			// registering the watcher for the path and getting a key
			// ignoring the key because i am not going to use it
			System.out.println("registering service....");
			mypath.register(wservice, ENTRY_CREATE);

			while (true) {
				// waiting for an event to occur and getting the key to that
				// event of that service
				System.out.println("waiting for events....");				
				WatchKey event_key = wservice.take();
				// after the key has been moved to "SIGNALLED" state, we get the
				// events by polling
				for (WatchEvent<?> event : event_key.pollEvents()) {
					// processing each event individually
					WatchEvent.Kind event_kind = event.kind();
					if (event_kind == ENTRY_CREATE) {
						String new_file = event.context().toString();
						
						// if previous file name is empty
						  // load this file name into the PFN
						if(prevFileName.isEmpty()){
				        	System.out.println("setting PFN");
				        	prevFileName = new_file;
				        }
						// else check if the current file name is same as PFN
						    // [YES] no change continue
						// [NO] execute organise for PFN and update PFN with new file name
						if(!new_file.equalsIgnoreCase(prevFileName)){
							organise(prevFileName);
						
							prevFileName = new_file;
						}
						
						
						
						
						System.out.println("new file found!!!");
						System.out
								.println("++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("FILE name---> :" + new_file);
						System.out
								.println("++++++++++++++++++++++++++++++++++++++++++++++");
						//organise(new_file);
					}
					if(event_kind == ENTRY_MODIFY){
						System.out.println("emtry modify event.....");
						System.out.printf("Entry Modify event occured with %s file", event.context().toString());
						System.out.println("----------------");
					}
				}
				if (event_key.reset()) {
					System.out.println("key has been reset");
					System.out.println("ready to recieve more events");
				}
			}

		} catch (Exception IOexc) {
			System.err.println("IOEXC:" + IOexc);
		}
	}

	private static void organise(String file_name) {
		System.out.println("organise...........");
		String[] name_parts = file_name.split("\\.");
		String extension = name_parts[name_parts.length - 1];
		System.out.println("extension is:" + extension);

		extensions ext = extensions.valueOf(extension);

		if(!ext.toString().equalsIgnoreCase("tmp")){
			// Path current_location = Paths.get(location, file_name);
			Path current_location = Paths.get(cleanerGUI.getLocation(), file_name);
			// System.out.println("current location" + current_location);

			Path new_location = Paths.get(ext.getlocation(), file_name);

			try {
				System.out.println("moving file now....");
				Files.move(current_location, new_location, ATOMIC_MOVE);
				System.out.println("moved to " + new_location);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("-----*******------");
		}else{
			System.out.println("FOUND TMP file"+file_name);
		}

	
		}
		}
