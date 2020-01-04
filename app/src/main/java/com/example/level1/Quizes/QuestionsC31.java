package com.example.level1.Quizes;

import android.os.Parcel;
import android.os.Parcelable;

public class QuestionsC31 implements Parcelable {

    private String questionC31;
    private String option1C31;
    private String option2C31;
    private String option3C31;
    private int answerNrC31;


    public QuestionsC31() {
    }

    public QuestionsC31(String questionC31, String option1C31, String option2C31, String option3C31, int answerNrC31) {
        this.questionC31 = questionC31;
        this.option1C31 = option1C31;
        this.option2C31 = option2C31;
        this.option3C31 = option3C31;
        this.answerNrC31 = answerNrC31;
    }

    protected QuestionsC31(Parcel in) {
        questionC31 = in.readString();
        option1C31 = in.readString();
        option2C31 = in.readString();
        option3C31= in.readString();
        answerNrC31 = in.readInt();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(questionC31);
        dest.writeString(option1C31);
        dest.writeString(option2C31);
        dest.writeString(option3C31);
        dest.writeInt(answerNrC31);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Parcelable.Creator<QuestionsC31> CREATOR = new Parcelable.Creator<QuestionsC31>() {
        @Override
        public QuestionsC31 createFromParcel(Parcel in) {
            return new QuestionsC31(in);
        }

        @Override
        public QuestionsC31[] newArray(int size) {
            return new QuestionsC31[size];
        }
    };


    public String getQuestionC31() {
        return questionC31;
    }

    public void setQuestionC31(String questionC31) {
        this.questionC31 = questionC31;
    }

    public String getOption1C31() {
        return option1C31;
    }

    public void setOption1C31(String option1C31) {
        this.option1C31 = option1C31;
    }

    public String getOption2C31() {
        return option2C31;
    }

    public void setOption2C31(String option2C31) {
        this.option2C31 = option2C31;
    }

    public String getOption3C31() {
        return option3C31;
    }

    public void setOption3C31(String option3C31) {
        this.option3C31 = option3C31;
    }

    public int getAnswerNrC31() {
        return answerNrC31;
    }

    public void setAnswerNrC31(int answerNrC31) {
        this.answerNrC31 = answerNrC31;
    }
}
