package it.unicam.cs.vectorrally.api.controller.file;

public class ResourceDirectoryFinder implements iDirectoryFinder{

    @Override
    public String getDirectory() {
        String resourceDirectory;
        String actualDirectory = System.getProperty("user.dir");
        if (actualDirectory.endsWith("app")) resourceDirectory = "../api/src/main/resources";
        else resourceDirectory = "api/src/main/resources";
        return resourceDirectory;
    }
}
