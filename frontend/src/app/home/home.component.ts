import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder } from '@angular/forms';
import { Router } from '@angular/router';
import { ApiService } from '../shared/api.service';
import { Homedata } from './home.model';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
})
export class HomeComponent implements OnInit {
  createPolicyForm!: FormGroup;
  viewPolicyForm!: FormGroup;
  homeModelObj: Homedata = new Homedata();
  allPolicyData: any;

  constructor(
    private formBuilder: FormBuilder,
    private api: ApiService,
    private route: Router
  ) {}

  ngOnInit(): void {
    this.createPolicyForm = this.formBuilder.group({
      policyId: [''],
      policyStatus: [''],
    });
    this.getAllData();
  }

  createPolicy() {
    this.homeModelObj.policyId = this.createPolicyForm.value.policyId;
    this.homeModelObj.policyStatus = this.createPolicyForm.value.policyStatus;

    this.api.postCreatePolicy(this.homeModelObj).subscribe(
      (res) => {
        console.log(res);
        alert('Policy Created Successfully!!');
        let ref = document.getElementById('clear');
        this.createPolicyForm.reset();
      },
      (err) => {
        alert('Something went wrong');
      }
    );
  }

  getAllData() {
    // this.api.getPolicy().subscribe(res=>{
    //   console.log("Result"+res.value);
    //   this.allPolicyData=res;
    // })
  }

  logout() {
    localStorage.clear();
    this.route.navigate(['login']);
  }
}