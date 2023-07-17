import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

import { map } from 'rxjs';

@Injectable({
  providedIn: 'root',
})
export class ApiService {
  result: any;
  constructor(private _http: HttpClient) {}
  postCreatePolicy(data: any) {
    return this._http.post<any>('http://localhost:3000/posts', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }
  getPolicy() {
    return this._http.get<any>('http://localhost:3000/createPolicy').pipe(
      map((res: any) => {
        console.log(res.value);
        return res;
      })
    );
  }
  postCreateConsumer(data: any) {
    return this._http.post<any>('http://localhost:3000/consumer', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }
  getConsumer() {
    return this._http.get<any>('http://localhost:3000/consumer').pipe(
      map((res: any) => {
        console.log(res.value);
        return res;
      })
    );
  }
  putConsumer(data: any) {
    return this._http.put<any>('http://localhost:3000/consumer', data).pipe(
      map((res: any) => {
        this.result = this.getConsumer();
        for (let i = 0; i < this.result.size(); i++) {
          if (this.result[i].CONSUMER_ID == data.CONSUMER_ID) {
            console.log(this.result[i]);
          }
        }
        return res;
      })
    );
  }
  postCreateBusiness(data: any) {
    return this._http.post<any>('http://localhost:3000/addBusiness', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  getQuotes(bVal: any, pVal: any, headers: any) {
    let _url = 'http://localhost:8082/getQuotesForPolicy/' + bVal + '/' + pVal;
    return this._http
      .get<any>(_url, {
        headers,
        responseType: 'text' as 'json',
      })
      .pipe(
        map((res: any) => {
          console.log('res:', res);
          return res;
        })
      );
  }

  getBusiness(headers: any) {
    return this._http
      .get<any>('http://localhost:8080/viewConsumerBusiness', {
        headers,
        responseType: 'text' as 'json',
      })
      .pipe(
        map((res: any) => {
          console.log('res:', res);
          return res;
        })
      );
  }

  postCreateProperty(data: any) {
    return this._http.post<any>('http://localhost:3000/addProperty', data).pipe(
      map((res: any) => {
        return res;
      })
    );
  }

  getProperty(pid: any, headers: any) {
    let _url = 'http://localhost:8080/viewConsumerProperty/' + pid;
    return this._http
      .get<any>(_url, {
        headers,
        responseType: 'text' as 'json',
      })
      .pipe(
        map((res: any) => {
          console.log('res: ', res);
          return res;
        })
      );
  }

  find(id: string) {
    return this._http.get<any>('http://localhost:3000/createPolicy').pipe(
      map((res: any) => {
        for (let i = 0; i < 3; i++) {
          if (res[i].policyId == id) {
            return res[i];
          }
        }
      })
    );
  }

  getConsumerDataById(id: any) {
    return this._http.get(`http://localhost:3000/consumer/${id}`);
  }

  getBusinessDataById(id: any) {
    return this._http.get(`http://localhost:3000/addBusiness/${id}`);
  }
}
