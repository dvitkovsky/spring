package api.controllers;

import api.entities.RequestEntity;
import api.schedulers.GetStatusOkTask;
import api.services.HttpBinServiceImpl;
import api.services.HttpBinService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RestController
@RequestMapping(path="/httpBin")
public class HttpBinController {

    @Autowired
    private HttpBinService httpBinService = new HttpBinServiceImpl();

    @Autowired
    private ThreadPoolTaskScheduler scheduler;

    @RequestMapping("/getStatusOk")
    public ResponseEntity<RequestEntity> getStatusOk() {
        return new ResponseEntity<>(httpBinService.getStatusOk(), HttpStatus.OK);
    }

    @RequestMapping("/randomDelay")
    public ResponseEntity<RequestEntity> randomDelay() {
        return new ResponseEntity<>(httpBinService.randomDelay(), HttpStatus.OK);
    }

    @RequestMapping("/getRequests")
    public ResponseEntity<List<RequestEntity>> getRequests() {
        return new ResponseEntity<>(httpBinService.getRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getAllGetOkRequests")
    public ResponseEntity<List<RequestEntity>> getAllGetOkRequests() {
        return new ResponseEntity<>(httpBinService.getAllGetOkRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getAllDelayRequests")
    public ResponseEntity<List<RequestEntity>> getAllDelayRequests() {
        return new ResponseEntity<>(httpBinService.getAllDelayRequests(), HttpStatus.OK);
    }

    @RequestMapping("/getStatusOkLoad")
    public ResponseEntity<List<RequestEntity>> getStatusOkLoad() {
        scheduler.scheduleAtFixedRate(new GetStatusOkTask(httpBinService), 20);
//        httpBinService.getStatusOkLoad(100, 2000);
        return new ResponseEntity<>(httpBinService.getRequests(), HttpStatus.OK);
    }
}
