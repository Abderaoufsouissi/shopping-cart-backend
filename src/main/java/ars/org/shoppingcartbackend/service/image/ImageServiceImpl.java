package ars.org.shoppingcartbackend.service.image;

import ars.org.shoppingcartbackend.model.Image;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;


@Service
public class ImageServiceImpl implements ImageService {
    @Override
    public Image getImageById(Long id) {
        return null;
    }

    @Override
    public void deleteImageById(Long id) {

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
