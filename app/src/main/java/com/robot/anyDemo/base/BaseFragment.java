package com.robot.anyDemo.base;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

/**
 * 项目名称：TestManyDemo
 * 类描述：
 * 创建人：Eric
 * 创建时间：2019-05-15 11:33
 * 修改人：Eric
 * 修改时间：2019-05-15 11:33
 * 修改备注：
 */
public abstract class BaseFragment<P extends BasePresenter> extends Fragment implements BaseView {
    //    public Context context;
    private ProgressDialog dialog;
    public Toast toast;
    protected P presenter;

    protected abstract P createPresenter();

    protected abstract int getLayoutId();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(getLayoutId(), null);
        presenter = createPresenter();
        return view;
    }

    protected abstract void initView();

    protected abstract void initData();

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
        initData();
    }


    /**
     * @param s
     */
    public void showtoast(String s) {
        if (toast == null) {
            toast = Toast.makeText(getContext().getApplicationContext(), s, Toast.LENGTH_LONG);
        }
        toast.show();
    }

    public void showFileDialog() {
        dialog = new ProgressDialog(getContext());
        dialog.setMessage("正在下载中,请稍后");
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setMax(100);
        dialog.show();
    }

    public void hideFileDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    private void closeLoadingDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }


    private void showLoadingDialog() {

        if (dialog == null) {
            dialog = new ProgressDialog(getContext());
        }
        dialog.setCancelable(false);
        dialog.show();
    }

    @Override
    public void showLoading() {
        showLoadingDialog();
    }


    @Override
    public void hideLoading() {
        closeLoadingDialog();
    }


    @Override
    public void showError(String msg) {
        showtoast(msg);
    }

    @Override
    public void onErrorCode(BaseModel model) {
    }

    @Override
    public void showLoadingFileDialog() {
        showFileDialog();
    }

    @Override
    public void hideLoadingFileDialog() {
        hideFileDialog();
    }

    @Override
    public void onProgress(long totalSize, long downSize) {
        if (dialog != null) {
            dialog.setProgress((int) (downSize * 100 / totalSize));
        }
    }
}
