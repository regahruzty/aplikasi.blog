import {Component, OnDestroy, OnInit} from '@angular/core';
import {Http} from '@angular/http';
import {Subscription} from 'rxjs/Subscription';
import {Tag} from './tag.model';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  title = 'app';
  onSubscribe: Subscription;
  tagContent: {
    content: Tag[],
    last: boolean,
    totalPages: number,
    totalElements: number,
    numberOfElements: number,
    first: boolean,
    size: number,
    number: number
  };

  ngOnInit(): void {
    this.onSubscribe = this.http.get('http://localhost:8080/api/tags/list').subscribe(
      data => this.tagContent = data.json(),
      error => console.error(error)
    );
  }

  ngOnDestroy(): void {
    this.onSubscribe.unsubscribe();
  }

  constructor(private http: Http) {

  }
}
