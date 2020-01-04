package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsT31 implements Parcelable {

    private String questionT31;
    private String option1T31;
    private String option2T31;
    private String option3T31;
    private int answerNrT31;


    public QuestionsT31() {
    }

    public QuestionsT31(String questionT31, String option1T31, String option2T31, String option3T31, int answerNrT31) {
        this.questionT31 = questionT31;
        this.option1T31 = option1T31;
        this.option2T31 = option2T31;
        this.option3T31 = option3T31;
        this.answerNrT31 = answerNrT31;
    }

    protected QuestionsT31(Parcel in) {
        questionT31 = in.readString();
        option1T31 = in.readString();
        option2T31 = in.readString();
        option3T31= in.readString();
        answerNrT31 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionT31);
        dest.writeString(option1T31);
        dest.writeString(option2T31);
        dest.writeString(option3T31);
        dest.writeInt(answerNrT31);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<QuestionsT31> CREATOR = new Creator<QuestionsT31>() {
        @Override
        public QuestionsT31 createFromParcel(Parcel in) {
            return new QuestionsT31(in);
        }

        @Override
        public QuestionsT31[] newArray(int size) {
            return new QuestionsT31[size];
        }
    };

    public String getQuestionT31() {
        return questionT31;
    }

    public void setQuestionT31(String questionT31) {
        this.questionT31 = questionT31;
    }

    public String getOption1T31() {
        return option1T31;
    }

    public void setOption1T31(String option1T31) {
        this.option1T31 = option1T31;
    }

    public String getOption2T31() {
        return option2T31;
    }

    public void setOption2T31(String option2T31) {
        this.option2T31 = option2T31;
    }

    public String getOption3T31() {
        return option3T31;
    }

    public void setOption3T31(String option3T31) {
        this.option3T31 = option3T31;
    }

    public int getAnswerNrT31() {
        return answerNrT31;
    }

    public void setAnswerNrT31(int answerNrT31) {
        this.answerNrT31 = answerNrT31;
    }
}


