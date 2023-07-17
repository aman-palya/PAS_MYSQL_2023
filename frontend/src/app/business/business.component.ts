import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-business',
  templateUrl: './business.component.html',
  styleUrls: ['./business.component.css'],
})
export class BusinessComponent implements OnInit {
  public addBusinessForm!: FormGroup;
  public addConsumerForm!: FormGroup;
  public addPropertyForm!: FormGroup;
  public currentForm: string = '';
  public formdata = {
    id: null,
    name: null,
    dob: null,
    pan: null,
    email: null,
    validity: null,
    agentName: null,
    agentId: null,
    business: {
      id: null,
      type: null,
      turnover: null,
      totalEmployees: null,
      businesscategory: null,
      businesstype: null,
      capitalInvested: null,
      businessValue: null,
      businessAge: null,
    },
    property: {
      pid: null,
      area: null,
      propertytype: null,
      insurancetype: null,
      buildingtype: null,
      propertyValue: null,
      costOfAsset: null,
      salvageValue: null,
      usefulLifeOfAsset: null,
      age: null,
      storey: null,
    },
  };

  constructor(
    private formBuilder: FormBuilder,
    private http: HttpClient,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.currentForm = 'consumer';

    this.addBusinessForm = this.formBuilder.group({
      id: ['', Validators.required],
      type: ['', Validators.required],
      turnover: ['', Validators.required],
      totalEmployees: ['', Validators.required],
      businesscategory: ['', Validators.required],
      businesstype: ['', Validators.required],
      capitalInvested: ['', Validators.required],
      businessValue: ['', Validators.required],
      businessAge: ['', Validators.required],
    });

    this.addConsumerForm = this.formBuilder.group({
      id: ['', Validators.required],
      name: ['', Validators.required],
      dob: ['', Validators.required],
      pan: ['', Validators.required],
      email: ['', Validators.required],
      validity: ['', Validators.required],
      agentName: ['', Validators.required],
      agentId: ['', Validators.required],
    });

    this.addPropertyForm = this.formBuilder.group({
      id: ['', Validators.required],
      area: ['', Validators.required],
      propertyType: ['', Validators.required],
      insuranceType: ['', Validators.required],
      buildingType: ['', Validators.required],
      propertyValue: ['', Validators.required],
      costOfAsset: ['', Validators.required],
      slvageValue: ['', Validators.required],
      usefulLifeofAsset: ['', Validators.required],
      age: ['', Validators.required],
      storey: ['', Validators.required],
    });
  }

  onBusinessFormSubmitted() {
    console.log(this.addBusinessForm.value);

    this.formdata.business.id = this.addBusinessForm.value.id;
    this.formdata.business.type = this.addBusinessForm.value.type;
    this.formdata.business.turnover = this.addBusinessForm.value.turnover;
    this.formdata.business.totalEmployees =
      this.addBusinessForm.value.totalEmployees;
    this.formdata.business.businesscategory =
      this.addBusinessForm.value.businesscategory;
    this.formdata.business.businesstype =
      this.addBusinessForm.value.businesstype;
    this.formdata.business.capitalInvested =
      this.addBusinessForm.value.capitalInvested;
    this.formdata.business.businessValue =
      this.addBusinessForm.value.businessValue;
    this.formdata.business.businessAge = this.addBusinessForm.value.businessAge;

    this.currentForm = 'property';
  }

  onConsumerFormSubmitted() {
    console.log(this.addConsumerForm.value);

    (this.formdata.id = this.addConsumerForm.value.id),
      (this.formdata.name = this.addConsumerForm.value.name),
      (this.formdata.dob = this.addConsumerForm.value.dob),
      (this.formdata.pan = this.addConsumerForm.value.pan),
      (this.formdata.email = this.addConsumerForm.value.email),
      (this.formdata.validity = this.addConsumerForm.value.validity),
      (this.formdata.agentName = this.addConsumerForm.value.agentName),
      (this.formdata.agentId = this.addConsumerForm.value.agentId),
      (this.currentForm = 'business');
  }

  onPropertyFormSubmitted() {
    console.log(this.addPropertyForm.value);

    this.formdata.property.pid = this.addPropertyForm.value.id;
    this.formdata.property.area = this.addPropertyForm.value.area;
    this.formdata.property.propertytype =
      this.addPropertyForm.value.propertyType;
    this.formdata.property.insurancetype =
      this.addPropertyForm.value.insuranceType;
    this.formdata.property.buildingtype =
      this.addPropertyForm.value.buildingType;
    this.formdata.property.propertyValue =
      this.addPropertyForm.value.propertyValue;
    this.formdata.property.costOfAsset = this.addPropertyForm.value.costOfAsset;
    this.formdata.property.salvageValue =
      this.addPropertyForm.value.slvageValue;
    this.formdata.property.usefulLifeOfAsset =
      this.addPropertyForm.value.usefulLifeofAsset;
    this.formdata.property.age = this.addPropertyForm.value.age;
    this.formdata.property.storey = this.addPropertyForm.value.storey;

    const jsonStr = JSON.stringify(this.formdata);
    const jsonobj = JSON.parse(jsonStr);
    console.log('json data: ', jsonStr);
    console.log('json oj', JSON.parse(jsonStr));

    let tokenStr = localStorage.getItem('token');

    //console.log(tokenStr);

    let tokenStr1 = 'Bearer ' + tokenStr;

    const headers = new HttpHeaders().set('Authorization', tokenStr1);
    this.http
      .post<any>('http://localhost:8080/createConsumerBusiness', jsonobj, {
        headers,
        responseType: 'text' as 'json',
      })
      .subscribe(
        (res) => {
          alert('Details Added successfully');
          this.addBusinessForm.reset();
          this.router.navigate(['home']);
          console.log('added res: ', res);
        },
        (err) => {
          alert('Something went wrong');
        }
      );
  }
}
