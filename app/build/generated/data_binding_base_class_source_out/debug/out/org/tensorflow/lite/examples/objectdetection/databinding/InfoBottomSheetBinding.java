// Generated by view binder compiler. Do not edit!
package org.tensorflow.lite.examples.objectdetection.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;
import org.tensorflow.lite.examples.objectdetection.R;

public final class InfoBottomSheetBinding implements ViewBinding {
  @NonNull
  private final NestedScrollView rootView;

  @NonNull
  public final NestedScrollView bottomSheetLayout;

  @NonNull
  public final TextView inferenceTimeVal;

  @NonNull
  public final TextView textView4;

  private InfoBottomSheetBinding(@NonNull NestedScrollView rootView,
      @NonNull NestedScrollView bottomSheetLayout, @NonNull TextView inferenceTimeVal,
      @NonNull TextView textView4) {
    this.rootView = rootView;
    this.bottomSheetLayout = bottomSheetLayout;
    this.inferenceTimeVal = inferenceTimeVal;
    this.textView4 = textView4;
  }

  @Override
  @NonNull
  public NestedScrollView getRoot() {
    return rootView;
  }

  @NonNull
  public static InfoBottomSheetBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static InfoBottomSheetBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.info_bottom_sheet, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static InfoBottomSheetBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      NestedScrollView bottomSheetLayout = (NestedScrollView) rootView;

      id = R.id.inference_time_val;
      TextView inferenceTimeVal = ViewBindings.findChildViewById(rootView, id);
      if (inferenceTimeVal == null) {
        break missingId;
      }

      id = R.id.textView4;
      TextView textView4 = ViewBindings.findChildViewById(rootView, id);
      if (textView4 == null) {
        break missingId;
      }

      return new InfoBottomSheetBinding((NestedScrollView) rootView, bottomSheetLayout,
          inferenceTimeVal, textView4);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
