import {Component, OnInit, OnDestroy} from '@angular/core';
import {Subject} from 'rxjs';
import {FooBarQuixService} from '../foo-bar-quix.service';
import {takeUntil} from 'rxjs/operators';

@Component({
  selector: 'app-foo-bar-quix',
  templateUrl: './foo-bar-quix.component.html'
})
export class FooBarQuixComponent implements OnInit, OnDestroy {

  convertedNumbers: NumberConverted[] = [];
  ngUnsubscribe = new Subject<void>();

  constructor(private fooBarQuixService: FooBarQuixService) {
  }

  ngOnInit(): void {
  }

  ngOnDestroy(): void {
    this.ngUnsubscribe.next();
    this.ngUnsubscribe.complete();
  }

  convertNumber(inputNumber: number): void {
    this.fooBarQuixService.convertNumber(inputNumber).pipe(takeUntil(this.ngUnsubscribe))
      .subscribe({
        next: (result) => {
          this.convertedNumbers.push({numberToConvert: inputNumber, result: result.result});
        }, error: (err) => {
          console.error(err);
          // Handle the error, such as showing a message to the user
        }
      });
  }
}

interface NumberConverted {
  numberToConvert: number;
  result: string;
}
