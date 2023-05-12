package app.ntnt.finalprojectexamonline.fragment;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import app.ntnt.finalprojectexamonline.R;
import app.ntnt.finalprojectexamonline.model.entites.User;
import app.ntnt.finalprojectexamonline.model.response.ResponseEntity;
import app.ntnt.finalprojectexamonline.services.BaseAPIService;
import app.ntnt.finalprojectexamonline.services.IUserService;
import app.ntnt.finalprojectexamonline.utils.AppConstrain;
import app.ntnt.finalprojectexamonline.utils.ContextUtil;
import app.ntnt.finalprojectexamonline.utils.SharedPrefManager;
import de.hdodenhof.circleimageview.CircleImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class AccountFragment extends Fragment {
    View view;
    private TextView fullName, email, address, phoneNumber, gender, numberTest, sumScore;
    CircleImageView avatar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        view= inflater.inflate(R.layout.fragment_account, container, false);
        view= inflater.inflate(R.layout.activity_account, container, false);
        init();
        loadData();
        return view;
    }
    @SuppressLint("SetTextI18n")
    private void renderData(User user){
        fullName.setText(user.getFirstName()+" "+user.getLastName());
        email.setText(user.getEmail());
        address.setText("");
        phoneNumber.setText(user.getPhoneNumber());
        gender.setText(user.getGender());
        String avt = user.getAvatar();
        Glide.with(view).load(avt).into(avatar);
    }

    private void loadData (){
        BaseAPIService.createService(IUserService.class).getProfile()
                .enqueue(new Callback<ResponseEntity>() {
                    @Override
                    public void onResponse(Call<ResponseEntity> call, Response<ResponseEntity> response) {
                        if (response.body()!= null){
                            if (!response.body().isError()){
                                User user = (User) AppConstrain.toObject(response.body().getData(), User.class);
                                renderData(user);
                            }
                        }
                        if (response.errorBody()!= null){
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseEntity> call, Throwable t) {

                    }
                });
    }

    private void init(){
        fullName = view.findViewById(R.id.tvFullName);
        email = view.findViewById(R.id.tvEmail);
        address = view.findViewById(R.id.tvAddress);
        phoneNumber = view.findViewById(R.id.tvPhoneNumber);
        gender = view.findViewById(R.id.tvGender);
        numberTest = view.findViewById(R.id.tvNumberTest);
        sumScore = view.findViewById(R.id.tvSumScore);
        avatar = view.findViewById(R.id.avatar);
    }
}