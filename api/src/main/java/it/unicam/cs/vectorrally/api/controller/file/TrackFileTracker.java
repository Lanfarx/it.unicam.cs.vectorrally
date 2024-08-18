package it.unicam.cs.vectorrally.api.controller.file;

import it.unicam.cs.vectorrally.api.view.iUtils;

import java.io.File;

public class TrackFileTracker implements iFileTracker{
    private final ResourceDirectoryFinder resourceDirectoryFinder;

    public TrackFileTracker(ResourceDirectoryFinder resourceDirectoryFinder) {
        this.resourceDirectoryFinder = resourceDirectoryFinder;
    }

    @Override
    public String findFile(int number) {
        File folder = new File(resourceDirectoryFinder.getDirectory());
        String filename = "track" + number + ".txt";
        File[] files = folder.listFiles(dirname -> dirname.getName().equals(filename));
        if(files != null && files.length > 0) {
            return files[number].getPath();
        } else iUtils.printlnText("File not found: " + filename);
        return null;
    }
}

