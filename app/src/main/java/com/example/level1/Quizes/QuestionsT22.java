package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT22 implements Parcelable {


    private String questionT22;
    private String option1T22;
    private String option2T22;
    private String option3T22;
    private int answerNrT22;


    public QuestionsT22() {
    }


    public QuestionsT22(String questionT22, String option1T22, String option2T22, String option3T22, int answerNrT22) {
        this.questionT22 = questionT22;
        this.option1T22 = option1T22;
        this.option2T22 = option2T22;
        this.option3T22 = option3T22;
        this.answerNrT22 = answerNrT22;
    }

    protected QuestionsT22(Parcel in) {
        questionT22 = in.readString();
        option1T22 = in.readString();
        option2T22 = in.readString();
        option3T22= in.readString();
        answerNrT22 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT22);
        dest.writeString(option1T22);
        dest.writeString(option2T22);
        dest.writeString(option3T22);
        dest.writeInt(answerNrT22);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT22> CREATOR = new Creator<QuestionsT22>() {
        @Override
        public QuestionsT22 createFromParcel(Parcel in) {
            return new QuestionsT22(in);
        }

        @Override
        public QuestionsT22[] newArray(int size) {
            return new QuestionsT22[size];
        }
    };

    public String getQuestionT22() {
        return questionT22;
    }

    public void setQuestionT22(String questionT22) {
        this.questionT22 = questionT22;
    }

    public String getOption1T22() {
        return option1T22;
    }

    public void setOption1T22(String option1T22) {
        this.option1T22 = option1T22;
    }

    public String getOption2T22() {
        return option2T22;
    }

    public void setOption2T22(String option2T22) {
        this.option2T22 = option2T22;
    }

    public String getOption3T22() {
        return option3T22;
    }

    public void setOption3T22(String option3T22) {
        this.option3T22 = option3T22;
    }

    public int getAnswerNrT22() {
        return answerNrT22;
    }

    public void setAnswerNrT22(int answerNrT22) {
        this.answerNrT22 = answerNrT22;
    }
}
