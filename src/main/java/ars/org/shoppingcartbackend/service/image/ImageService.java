package ars.org.shoppingcartbackend.service.image;

import ars.org.shoppingcartbackend.dto.ImageDto;
import ars.org.shoppingcartbackend.model.Image;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ImageService {
    Image getImageById(Long id);
    void deleteImageById(Long id);
    List<ImageDto> saveImage(List<MultipartFile> files, Long productId);
    void updateImage(MultipartFile file, Long imageId);




}
