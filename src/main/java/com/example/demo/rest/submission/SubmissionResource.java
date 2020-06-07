package com.example.demo.rest.submission;

import com.example.demo.domain.submission.Submission;
import com.example.demo.domain.submission.SubmissionService;
import com.example.demo.rest.submission.vm.SubmissionDto;
import com.example.demo.utils.SecurityUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api/v1")
public class SubmissionResource {

    @Autowired
    private SubmissionService service;

    @Autowired
    private SubmissionMapper submissionMapper;

    @GetMapping("scoreboards")
    public List<SubmissionDto> getSubmissionByDate(@RequestParam("date")String time){
        return submissionMapper.toSubmissionDtos(service.getSubmissionByDate(time));
    }

    @PostMapping("publish")
    @ResponseStatus(HttpStatus.CREATED)
    public SubmissionDto addSubmission(@RequestBody @Valid SubmissionDto submissionDto){
        final String emailCurrent = SecurityUtils.getCurrentUserEmail();
        final Submission submission= service.addSubmission(emailCurrent,submissionMapper.toSubmission(submissionDto));
        return submissionMapper.toSubmissionDto(submission);
    }

    @GetMapping("get-last-submission")
    public SubmissionDto getLastSubmission(){
        final String emailCurrent = SecurityUtils.getCurrentUserEmail();
        return submissionMapper.toSubmissionDto(service.getLastSubmission(emailCurrent));
    }

    @GetMapping("overall")
    public List<SubmissionDto> getAllBestSubmissionOfEmployee(){
        return submissionMapper.toSubmissionDtos(service.getAllBestSubmissionOfEmployee());
    }
}
