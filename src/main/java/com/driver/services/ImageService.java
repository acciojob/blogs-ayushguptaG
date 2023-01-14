package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository9;

    public Image createAndReturn(Blog blog, String description, String dimensions){
        //create an image based on given parameters and add it to the imageList of given blog
        Image newImage= new Image(description, dimensions);

        List<Image> imageList= blog.getImageList();

        imageList.add(newImage);
        newImage.setBlog(blog);
        blog.setImageList(imageList);

        blogRepository9.save(blog);
        return newImage;

    }

    public void deleteImage(Image image){

        imageRepository2.delete(image);
    }

    public Image findById(int id) {

        return imageRepository2.findById(id).get();
    }

    public int countImagesInScreen(Image image, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

        String size= image.getDimensions();

        int imageArea= findArea(size);
        int screeArea= findArea(screenDimensions);

        int requiredImages= screeArea/imageArea;
        return requiredImages;

    }
    public int findArea(String size){
        int length= Integer.valueOf(size.charAt(0));
        int breadth= Integer.valueOf(size.charAt(0));

        int Area= length*breadth;
        return Area;
    }
}
