import {Component} from '@angular/core';
import 'rxjs/add/operator/map';
import {FormControl, FormGroup, Validators} from '@angular/forms';
import {Country} from '../app/model/Country';
import {MainService} from './service/MainService';
import {HttpClient} from '@angular/common/http';
import {Response} from '@angular/http';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  readonly URL: 'https://jsonplaceholder.typicode.com/posts';
  posts: any;
  title = 'app';
  private country: Country;
  private mainService: MainService;
  private countryForm: FormGroup;

  constructor(private http: HttpClient) {
    this.setForm();

  }

  get name() {
    return this.countryForm.get('name').value;
  }

  get visa() {
    return this.countryForm.get('visa').value;
  }

  show() {
    alert('EZ');
  }

  setForm() {
    this.countryForm = new FormGroup({
      name: new FormControl('', [Validators.required, Validators.pattern('[a-zA-Z0-9]+')]),
      visa: new FormControl()
    });
  }

  getPosts() {
    this.posts = this.http.get(this.URL);
  }

  submit() {
    this.country = new Country();
    this.country.name = this.name;
    this.country.visa = this.visa;
    // // console.log(this.country)
    return this.http.post('/api/save', this.country).subscribe(
      (response: Response) => {
        console.log(response);
        this.countryForm.reset();
      }
    );
  }


}
