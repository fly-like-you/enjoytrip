package com.ssafy.post.model;

import java.util.ArrayList;
import java.util.List;

public class PostSummariesDto {
    List<PostSummaryDto> summariesDto = new ArrayList<>();

    public PostSummariesDto(List<PostSummaryDto> summariesDto) {
        this.summariesDto = summariesDto;
    }

    public PostSummariesDto() {
    }

    public List<PostSummaryDto> getSummariesDto() {
        return summariesDto;
    }

    public void setSummariesDto(List<PostSummaryDto> summariesDto) {
        this.summariesDto = summariesDto;
    }
}
