package com.example.myapplication.ui.clothes;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import com.example.myapplication.databinding.FragmentClothesBinding;
import java.util.ArrayList;
import java.util.List;

public class ClothesFragment extends Fragment {

    private FragmentClothesBinding binding;
    private ActivityResultLauncher<String[]> photoPickerLauncher;
    private List<Uri> selectedImages = new ArrayList<>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmentClothesBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        // Initialize the photo picker
        photoPickerLauncher = registerForActivityResult(
                new ActivityResultContracts.OpenDocument(),
                uri -> {
                    if (uri != null) {
                        // Add the selected image to the list and display it in the grid
                        selectedImages.add(uri);
                        addImageToGrid(uri);
                    }
                });

        // Set the button click listener to launch the photo picker
        binding.pickImageButton.setOnClickListener(v -> {
            // Launch the photo picker for images
            photoPickerLauncher.launch(new String[]{"image/*"});
        });

        return root;
    }

    // Helper method to add an image to the GridLayout
    private void addImageToGrid(Uri uri) {
        GridLayout gridLayout = binding.gridLayout;

        // Create a new ImageView for the image
        ImageView imageView = new ImageView(getContext());
        imageView.setLayoutParams(new ViewGroup.LayoutParams(250, 250)); // Set size of each image
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP); // Scale type
        imageView.setImageURI(uri); // Set the image URI

        // Add the ImageView to the GridLayout
        gridLayout.addView(imageView);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
