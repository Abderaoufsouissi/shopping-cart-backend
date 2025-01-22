package ars.org.shoppingcartbackend.service.image;

import ars.org.shoppingcartbackend.model.Image;
import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    Image saveImage(MultipartFile file, Long productId);
    Void updateImage(MultipartFile file, Long productId);




}
