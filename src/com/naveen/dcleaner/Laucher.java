<<<<<<< HEAD
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
<<<<<<< HEAD
<<<<<<< HEAD
import static java.nio.file.StandardWatchEventKinds.*;
import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;

public class Laucher {

	private static final String location = "C:\\Users\\Naveen\\Desktop\\Testing";
	private static final String picture_location = "C:\\Users\\Naveen\\Desktop\\Pictures";
	private static final String music_location = "C:\\Users\\Naveen\\Desktop\\Music";
	private static final String doc_location = "C:\\Users\\Naveen\\Desktop\\Docum";

	private enum extensions {
		jpg(picture_location), mp3(music_location), doc(doc_location), docx(
				doc_location), pdf(doc_location), gif(picture_location), png(picture_location);
=======

public class Laucher {

=======

public class Laucher {

>>>>>>> temp
	
	private enum extensions {		
		jpg(cleanerGUI.getPicture_location()), mp3(cleanerGUI
				.getMusic_location()), doc(cleanerGUI.getDoc_location()), docx(
						cleanerGUI.getDoc_location()), pdf(cleanerGUI.getDoc_location()), gif(
								cleanerGUI.getPicture_location()), png(cleanerGUI
										.getPicture_location()), tmp("C:\\Users\\Naveen\\Downloads");
<<<<<<< HEAD
>>>>>>> temp
=======
>>>>>>> temp

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
		cleanerGUI.callLauch(args);	

	}

	public static void startWatching() {		
		Path mypath = Paths.get(cleanerGUI.getLocation());
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
				// WatchKey event_key = wservice.
				WatchKey event_key = wservice.take();
				// after the key has been moved to "SIGNALLED" state, we get the
				// events by polling
				for (WatchEvent<?> event : event_key.pollEvents()) {
					// processing each event individually
					WatchEvent.Kind event_kind = event.kind();
					if (event_kind == ENTRY_CREATE) {
						String new_file = event.context().toString();
<<<<<<< HEAD
<<<<<<< HEAD
						System.out.println("new file found!!!");
						System.out
						.println("++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("FILE name---> : " + new_file);
					System.out
							.println("++++++++++++++++++++++++++++++++++++++++++++++");
						organise(new_file);
					}
				}
				if (event_key.reset()) {
					System.out.println("key has been reset");
					System.out.println("ready to recieve more events");
=======

						System.out.println("new file found!!!");
						
					}
					if (event_kind == ENTRY_MODIFY) {
						System.out.println("emtry modify event.....");
						System.out.printf(
								"Entry Modify event occured with %s file",
								event.context().toString());
						System.out.println("----------------");
					}
				}
				if (event_key.reset()) {
=======

						System.out.println("new file found!!!");
						
					}
					if (event_kind == ENTRY_MODIFY) {
						System.out.println("emtry modify event.....");
						System.out.printf(
								"Entry Modify event occured with %s file",
								event.context().toString());
						System.out.println("----------------");
					}
				}
				if (event_key.reset()) {
>>>>>>> temp
					System.out.println("key has been reset and ready for more events");					
				}else{
					System.out.println("*****************failure to reset the key**********");
					System.exit(1);
<<<<<<< HEAD
>>>>>>> temp
=======
>>>>>>> temp
				}
			}

		} catch (Exception IOexc) {
			System.err.println("IOEXC:" + IOexc);
		}

	}

	/**
	 * moves the file depending on the type
	 * @param file_name
	 */
	@SuppressWarnings("unused")
	private static void organise(String file_name) {
		System.out.println("organise...........");
		String[] name_parts = file_name.split("\\.");
		System.out.println(name_parts);
		String extension = name_parts[name_parts.length - 1];
		System.out.println("extension is:" + extension);
		
<<<<<<< HEAD
<<<<<<< HEAD
		Path current_location = Paths.get(location, file_name);
		//System.out.println("current location" + current_location);

		Path new_location = Paths.get(ext.getlocation(), file_name);

		try {
			System.out.println("moving file now....");
			Files.move(current_location, new_location, ATOMIC_MOVE);
			System.out.println("moved to "+ new_location);			
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("-----*******------");
=======
		if(checkType(extension)){
			extensions ext = extensions.valueOf(extension);
			Path current_location = Paths.get(cleanerGUI.getLocation(),
					file_name);
			Path new_location = Paths.get(ext.getlocation(), file_name);

			try {
				System.out.println("moving file now....");
				Files.move(current_location, new_location, ATOMIC_MOVE);
				System.out.println("moved to " + new_location);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("-----*******------");
		}		
	}
	
	/**
	 * method to validate the types supported
	 * @param type
	 * @return boolean
	 */
	private static boolean checkType(String type){
		for(extensions e : extensions.values()){
			if(e.toString().equalsIgnoreCase(type)){
				return true;
			}
		}
	  return false;
>>>>>>> temp
	}
}
<<<<<<< HEAD
=======
package com.naveen.dcleaner;

import static java.nio.file.StandardCopyOption.ATOMIC_MOVE;
import static java.nio.file.StandardWatchEventKinds.ENTRY_CREATE;

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
				.getPicture_location());

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

		cleanerGUI.launch(args);

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
						System.out.println("new file found!!!");
						System.out
								.println("++++++++++++++++++++++++++++++++++++++++++++++");
						System.out.println("FILE name---> : " + new_file);
						System.out
								.println("++++++++++++++++++++++++++++++++++++++++++++++");
						organise(new_file);
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
=======
		if(checkType(extension)){
			extensions ext = extensions.valueOf(extension);
			Path current_location = Paths.get(cleanerGUI.getLocation(),
					file_name);
			Path new_location = Paths.get(ext.getlocation(), file_name);

			try {
				System.out.println("moving file now....");
				Files.move(current_location, new_location, ATOMIC_MOVE);
				System.out.println("moved to " + new_location);
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("-----*******------");
		}		
	}
	
	/**
	 * method to validate the types supported
	 * @param type
	 * @return boolean
	 */
	private static boolean checkType(String type){
		for(extensions e : extensions.values()){
			if(e.toString().equalsIgnoreCase(type)){
				return true;
			}
		}
	  return false;
>>>>>>> temp
	}
}
<<<<<<< HEAD
>>>>>>> origin/temp
=======
=======
>>>>>>> temp
/*System.out
.println("++++++++++++++++++++++++++++++++++++++++++++++");
System.out.println("FILE name---> :" + new_file);
System.out
.println("++++++++++++++++++++++++++++++++++++++++++++++");
<<<<<<< HEAD
// organise(new_file);*/
>>>>>>> temp
=======
// organise(new_file);*/
>>>>>>> temp
