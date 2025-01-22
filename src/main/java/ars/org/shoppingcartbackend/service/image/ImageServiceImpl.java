package ars.org.shoppingcartbackend.service.image;

import ars.org.shoppingcartbackend.dto.ImageDto;
import ars.org.shoppingcartbackend.exceptions.RessourceNotFoundException;
import ars.org.shoppingcartbackend.model.Image;
import ars.org.shoppingcartbackend.repository.ImageRepository;
import ars.org.shoppingcartbackend.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ImageServiceImpl implements ImageService {

    private final ImageRepository imageRepository;
    private final ProductService productService;

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
    public List<ImageDto> saveImage(List<MultipartFile> files, Long productId) {

    }

    @Override
    public void updateImage(MultipartFile file, Long imageId) {
        Image image = getImageById(imageId);
        try {
            image.setFileName(file.getOriginalFilename());
            image.setFileType(file.getContentType());
            image.setImage(new SerialBlob(file.getBytes()));
            imageRepository.save(image);
        } catch (IOException | SQLException e) {
            throw new RuntimeException(e.getMessage());
        }


    }
}
