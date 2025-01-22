package ars.org.shoppingcartbackend.service.image;

import ars.org.shoppingcartbackend.exceptions.RessourceNotFoundException;
import ars.org.shoppingcartbackend.model.Image;
import ars.org.shoppingcartbackend.repository.ImageRepository;
import ars.org.shoppingcartbackend.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ProductRepository productRepository;

    @Override
    public Image getImageById(Long id) {
        return imageRepository.findById(id).orElseThrow(
                ()-> new RessourceNotFoundException("No image found with id : "+id));


    }

    @Override
    public void deleteImageById(Long id) {
        imageRepository.findById(id).ifPresentOrElse(
                imageRepository::delete,
                ()-> {throw new RessourceNotFoundException("No image found with id : "+id);}
        );

    }

    @Override
    public Image saveImage(MultipartFile file, Long productId) {
        return null;
    }

    @Override
    public Void updateImage(MultipartFile file, Long productId) {
        return null;
    }
}
